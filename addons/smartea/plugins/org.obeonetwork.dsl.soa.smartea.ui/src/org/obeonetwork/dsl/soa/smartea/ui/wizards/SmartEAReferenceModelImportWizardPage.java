package org.obeonetwork.dsl.soa.smartea.ui.wizards;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.File;
import java.util.Objects;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.beans.typed.BeanProperties;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jface.databinding.swt.typed.WidgetProperties;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class SmartEAReferenceModelImportWizardPage extends WizardPage {

	private SmartEAReferenceModelImportWizard wizard;
	
	private DataBindingContext bindingContext;
	
	private SmartEAReferenceModelImportWizardModel model;
	
	private Text txtPrismFilePath;

	private PropertyChangeListener prismFilePathModelListener;
	
	public SmartEAReferenceModelImportWizardPage(SmartEAReferenceModelImportWizard smartEAReferenceModelImportWizard) {
		super("smartEAReferenceModelImportWizardPage");
		setTitle("SmartEA Reference Model import");
		setDescription("Select prism file to import.");
		this.wizard = smartEAReferenceModelImportWizard;
		this.model = new SmartEAReferenceModelImportWizardModel();
	}

	static class SmartEAReferenceModelImportWizardModel {
		private String prismFilePath = "";
		
		private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
		
		public void addPropertyChangeListener(String propertyName, PropertyChangeListener listener) {
			propertyChangeSupport.addPropertyChangeListener(propertyName, listener);
		}

		public void removePropertyChangeListener(PropertyChangeListener listener) {
			propertyChangeSupport.removePropertyChangeListener(listener);
		}

		public String getPrismFilePath() {
			return prismFilePath;
		}

		public static final String PRISM_FILE_PATH_PROP = "prismFilePath";
		public void setPrismFilePath(String prismFilePath) {
			if(!Objects.equals(this.prismFilePath, prismFilePath)) 
				propertyChangeSupport.firePropertyChange(PRISM_FILE_PATH_PROP, this.prismFilePath, this.prismFilePath = prismFilePath); //$NON-NLS-1$
		}
		
	}
	
	@Override
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);

		setControl(container);
		container.setLayout(new GridLayout(3, false));
		
		Label lblPrismFilePath = new Label(container, SWT.NONE);
		lblPrismFilePath.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblPrismFilePath.setText("Prism file");
		
		txtPrismFilePath = new Text(container, SWT.BORDER);
		txtPrismFilePath.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Button btnSelectPrismFilePath = new Button(container, SWT.NONE);
		btnSelectPrismFilePath.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				FileDialog dialog = new FileDialog(SmartEAReferenceModelImportWizardPage.this.getShell(), SWT.OPEN);
				dialog.setFilterExtensions(new String [] { "*.prism" }); //$NON-NLS-1$
				dialog.setFilterPath(model.getPrismFilePath());
				String prismFilePath = dialog.open();
				if(prismFilePath != null) {
					model.setPrismFilePath(prismFilePath);
				}
			}
		});
		btnSelectPrismFilePath.setText("...");
		
		model.setPrismFilePath(ResourcesPlugin.getWorkspace().getRoot().getLocation().toOSString());
		
		bindingContext = initDataBindings();
		
		prismFilePathModelListener = new PropertyChangeListener() {
			
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				setPageComplete(isComplete());
				if(!fileExists()) {
					setErrorMessage("Selected file does not exist.");
				} else {
					setErrorMessage(null);
				}
			}

		};
		model.addPropertyChangeListener(SmartEAReferenceModelImportWizardModel.PRISM_FILE_PATH_PROP, prismFilePathModelListener); //$NON-NLS-1$
		
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected DataBindingContext initDataBindings() {
		DataBindingContext bindingContext = new DataBindingContext();
		
		// prismFilePath
		IObservableValue observeTextPrismFilePathObserveWidget = WidgetProperties.text(SWT.Modify).observe(txtPrismFilePath);
		IObservableValue textTxtPrismFilePathObserveValue = BeanProperties.value(SmartEAReferenceModelImportWizardModel.PRISM_FILE_PATH_PROP).observe(model);
		bindingContext.bindValue(observeTextPrismFilePathObserveWidget, textTxtPrismFilePathObserveValue, null, null);
				
		return bindingContext;
	}

	private boolean fileExists() {
		File file = new File(model.getPrismFilePath());
		return file.exists() && file.isFile();
	}
	
	public boolean isComplete() {
		return fileExists();
	}

	@Override
	public void dispose() {
		model.removePropertyChangeListener(prismFilePathModelListener);
		bindingContext.dispose();
		
		super.dispose();
	}
	
	public String getPrismFilePath() {
		return model.getPrismFilePath();
	}

}
