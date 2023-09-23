package org.obeonetwork.dsl.object.edit.util;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.obeonetwork.dsl.environment.PrimitiveType;
import org.obeonetwork.dsl.object.PrimitiveTypeValue;

public class PrimitiveTypeValueService {

	private interface IPrimitiveTypeDataStrategy {
		public PrimitiveTypeValue setDefaultPrimitiveTypeData(PrimitiveTypeValue ptv);
		public PrimitiveTypeValue setPrimitiveTypeDataAsString(PrimitiveTypeValue ptv, String dataAsString);
		public String getPrimitiveTypeDataAsString(PrimitiveTypeValue ptv);
	}

	@SuppressWarnings("serial")
	private static final Map<String, IPrimitiveTypeDataStrategy> PRIMITIVE_TYPE_DATA_STRATEGIES = new HashMap<String, IPrimitiveTypeDataStrategy>() {{

		put("Binary", new IPrimitiveTypeDataStrategy() {
			@Override
			public PrimitiveTypeValue setDefaultPrimitiveTypeData(PrimitiveTypeValue ptv) {
				ptv.setData("");
				return ptv;
			}

			@Override
			public PrimitiveTypeValue setPrimitiveTypeDataAsString(PrimitiveTypeValue ptv, String dataAsString) {
				ptv.setData(hexToText(dataAsString));
				return ptv;
			}

			@Override
			public String getPrimitiveTypeDataAsString(PrimitiveTypeValue ptv) {
				return (ptv.getData() instanceof String)? 
						textToHex((String) ptv.getData()) : 
						Objects.toString(ptv.getData());
			}
		});

		put("Boolean", new IPrimitiveTypeDataStrategy() {
			@Override
			public PrimitiveTypeValue setDefaultPrimitiveTypeData(PrimitiveTypeValue ptv) {
				ptv.setData(Boolean.TRUE);
				return ptv;
			}

			@Override
			public PrimitiveTypeValue setPrimitiveTypeDataAsString(PrimitiveTypeValue ptv, String dataAsString) {
				ptv.setData(Boolean.valueOf(dataAsString));
				return ptv;
			}

			@Override
			public String getPrimitiveTypeDataAsString(PrimitiveTypeValue ptv) {
				return Objects.toString(ptv.getData());
			}
		});

		put("Date", new PrimitiveTypeDataDateStrategy("yyyy-MM-dd"));

		put("Double", new IPrimitiveTypeDataStrategy() {
			@Override
			public PrimitiveTypeValue setDefaultPrimitiveTypeData(PrimitiveTypeValue ptv) {
				ptv.setData(Double.valueOf(0));
				return ptv;
			}

			@Override
			public PrimitiveTypeValue setPrimitiveTypeDataAsString(PrimitiveTypeValue ptv, String dataAsString) {
				ptv.setData(Double.valueOf(dataAsString));
				return ptv;
			}

			@Override
			public String getPrimitiveTypeDataAsString(PrimitiveTypeValue ptv) {
				return Objects.toString(ptv.getData());
			}
		});

		put("Float", new IPrimitiveTypeDataStrategy() {
			@Override
			public PrimitiveTypeValue setDefaultPrimitiveTypeData(PrimitiveTypeValue ptv) {
				ptv.setData(Float.valueOf(0));
				return ptv;
			}

			@Override
			public PrimitiveTypeValue setPrimitiveTypeDataAsString(PrimitiveTypeValue ptv, String dataAsString) {
				ptv.setData(Float.valueOf(dataAsString));
				return ptv;
			}

			@Override
			public String getPrimitiveTypeDataAsString(PrimitiveTypeValue ptv) {
				return Objects.toString(ptv.getData());
			}
		});

		put("Integer", new IPrimitiveTypeDataStrategy() {
			@Override
			public PrimitiveTypeValue setDefaultPrimitiveTypeData(PrimitiveTypeValue ptv) {
				ptv.setData(Integer.valueOf(0));
				return ptv;
			}

			@Override
			public PrimitiveTypeValue setPrimitiveTypeDataAsString(PrimitiveTypeValue ptv, String dataAsString) {
				ptv.setData(Integer.valueOf(dataAsString));
				return ptv;
			}

			@Override
			public String getPrimitiveTypeDataAsString(PrimitiveTypeValue ptv) {
				return Objects.toString(ptv.getData());
			}
		});

		put("Long", new IPrimitiveTypeDataStrategy() {
			@Override
			public PrimitiveTypeValue setDefaultPrimitiveTypeData(PrimitiveTypeValue ptv) {
				ptv.setData(Long.valueOf(0));
				return ptv;
			}

			@Override
			public PrimitiveTypeValue setPrimitiveTypeDataAsString(PrimitiveTypeValue ptv, String dataAsString) {
				ptv.setData(Long.valueOf(dataAsString));
				return ptv;
			}

			@Override
			public String getPrimitiveTypeDataAsString(PrimitiveTypeValue ptv) {
				return Objects.toString(ptv.getData());
			}
		});

		put("String", new IPrimitiveTypeDataStrategy() {
			@Override
			public PrimitiveTypeValue setDefaultPrimitiveTypeData(PrimitiveTypeValue ptv) {
				ptv.setData("");
				return ptv;
			}

			@Override
			public PrimitiveTypeValue setPrimitiveTypeDataAsString(PrimitiveTypeValue ptv, String dataAsString) {
				ptv.setData(dataAsString);
				return ptv;
			}

			@Override
			public String getPrimitiveTypeDataAsString(PrimitiveTypeValue ptv) {
				return Objects.toString(ptv.getData());
			}
		});

		put("Time", new PrimitiveTypeDataDateStrategy("HH:mm:ss"));

		put("Timestamp", new PrimitiveTypeDataDateStrategy("yyyy-MM-dd HH:mm:ss SSS"));

	}};

	private static class PrimitiveTypeDataDateStrategy implements IPrimitiveTypeDataStrategy {

		private String datePattern;

		public PrimitiveTypeDataDateStrategy(String datePattern) {
			this.datePattern = datePattern;
		}

		@Override
		public PrimitiveTypeValue setDefaultPrimitiveTypeData(PrimitiveTypeValue ptv) {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(datePattern);
			try {
				ptv.setData(simpleDateFormat.parse(simpleDateFormat.format(new Date())));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			return ptv;
		}

		@Override
		public PrimitiveTypeValue setPrimitiveTypeDataAsString(PrimitiveTypeValue ptv, String dataAsString) {
			try {
				ptv.setData(new SimpleDateFormat(datePattern).parse(dataAsString));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			return ptv;
		}

		@Override
		public String getPrimitiveTypeDataAsString(PrimitiveTypeValue ptv) {
			return (ptv.getData() instanceof Date)? 
					new SimpleDateFormat(datePattern).format((Date)ptv.getData()) : 
					Objects.toString(ptv.getData());
		}

	}

	private static IPrimitiveTypeDataStrategy getPrimitiveTypeDataStrategy(PrimitiveType primitiveType) {
		IPrimitiveTypeDataStrategy strategy = PRIMITIVE_TYPE_DATA_STRATEGIES.get(primitiveType.getName());
		if(strategy == null) {
			System.out.println(String.format("[ERROR] Unhandled primitive type %s", primitiveType.getName()));
		}
		return strategy;
	}

	public static PrimitiveTypeValue setDefaultPrimitiveTypeData(PrimitiveTypeValue ptv) {
		if(ptv.getMetaType() instanceof PrimitiveType) {
			IPrimitiveTypeDataStrategy strategy = getPrimitiveTypeDataStrategy((PrimitiveType) ptv.getMetaType());
			if(strategy != null) {
				strategy.setDefaultPrimitiveTypeData(ptv);
			}
		} else {
			ptv.setData("");
		}

		return ptv;
	}

	public static PrimitiveTypeValue setPrimitiveTypeDataAsString(PrimitiveTypeValue ptv, String dataAsString) {

		if(ptv.getMetaType() instanceof PrimitiveType) {
			IPrimitiveTypeDataStrategy strategy = getPrimitiveTypeDataStrategy((PrimitiveType) ptv.getMetaType());
			if(strategy != null) {
				strategy.setPrimitiveTypeDataAsString(ptv, dataAsString);
			}
		} else {
			ptv.setData(dataAsString);
		}

		return ptv;
	}

	public static String getPrimitiveTypeDataAsString(PrimitiveTypeValue ptv) {
		String dataAsString = null;

		if(ptv.getMetaType() instanceof PrimitiveType) {
			IPrimitiveTypeDataStrategy strategy = getPrimitiveTypeDataStrategy((PrimitiveType) ptv.getMetaType());
			if(strategy != null) {
				dataAsString = strategy.getPrimitiveTypeDataAsString(ptv);
			}
		}

		if(dataAsString == null) {
			dataAsString = Objects.toString(ptv.getData());
		}

		return dataAsString;
	}

	private static final List<String> INTEGER_LIKE_TYPE_NAMES = Arrays.asList("Integer", "Long");
	
	public static PrimitiveTypeValue setPrimitiveTypeDataMetaType(PrimitiveTypeValue ptv, PrimitiveType metaType) {
		String dataAsString = getPrimitiveTypeDataAsString(ptv);
		ptv.setMetaType(metaType);
		if(INTEGER_LIKE_TYPE_NAMES.contains(metaType.getName()) && dataAsString.contains(".")) {
			dataAsString = dataAsString.substring(0, dataAsString.lastIndexOf("."));
		}
		setPrimitiveTypeDataAsString(ptv, dataAsString);
		return ptv;
	}

	private static String hexToText(String hex) {
		int l = hex.length();
		byte[] data = new byte[l / 2];
		for (int i = 0; i < l; i += 2) {
			data[i / 2] = (byte) ((Character.digit(hex.charAt(i), 16) << 4) + Character.digit(hex.charAt(i + 1), 16));
		}
		return new String(data);
	}

	private static final char[] HEX_CHARS = "0123456789ABCDEF".toCharArray();

	private static String textToHex(String text) {
		byte[] buf = null;
		try {
			buf = text.getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		char[] chars = new char[2 * buf.length];
		for (int i = 0; i < buf.length; ++i) {
			chars[2 * i] = HEX_CHARS[(buf[i] & 0xF0) >>> 4];
			chars[2 * i + 1] = HEX_CHARS[buf[i] & 0x0F];
		}
		return new String(chars);
	}	

}
