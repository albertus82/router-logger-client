package it.albertus.router.client;

import it.albertus.jface.JFaceResources;
import it.albertus.router.client.resources.Resources;
import it.albertus.util.Configuration;
import it.albertus.util.ConfigurationException;

public class RouterLoggerConfiguration extends Configuration {

	private static class Singleton {
		private static final RouterLoggerConfiguration instance = new RouterLoggerConfiguration();
	}

	public static RouterLoggerConfiguration getInstance() {
		return Singleton.instance;
	}

	public static final String FILE_NAME = "routerloggerclient.cfg";

	private RouterLoggerConfiguration() {
		/* Caricamento della configurazione... */
		super(FILE_NAME);
		init();
	}

	private void init() {
		/* Impostazione lingua */
		if (this.contains("language")) {
			final String language = this.getString("language");
			Resources.setLanguage(language);
			JFaceResources.setLanguage(language);
		}
	}

	@Override
	public void reload() {
		super.reload();
		init();
	}

	@Override
	public Long getLong(final String key) {
		try {
			return super.getLong(key);
		}
		catch (final RuntimeException re) {
			throw new ConfigurationException(Resources.get("err.invalid.cfg.number", key, Long.MIN_VALUE, Long.MAX_VALUE) + ' ' + Resources.get("err.review.cfg", getFileName()), re, key);
		}
	}

	@Override
	public long getLong(final String key, final long defaultValue) {
		try {
			return super.getLong(key, defaultValue);
		}
		catch (final RuntimeException re) {
			throw new ConfigurationException(Resources.get("err.invalid.cfg.number", key, Long.MIN_VALUE, Long.MAX_VALUE) + ' ' + Resources.get("err.review.cfg", getFileName()), re, key);
		}
	}

	@Override
	public Integer getInt(final String key) {
		try {
			return super.getInt(key);
		}
		catch (final RuntimeException re) {
			throw new ConfigurationException(Resources.get("err.invalid.cfg.number", key, Integer.MIN_VALUE, Integer.MAX_VALUE) + ' ' + Resources.get("err.review.cfg", getFileName()), re, key);
		}
	}

	@Override
	public int getInt(final String key, final int defaultValue) {
		try {
			return super.getInt(key, defaultValue);
		}
		catch (final RuntimeException re) {
			throw new ConfigurationException(Resources.get("err.invalid.cfg.number", key, Integer.MIN_VALUE, Integer.MAX_VALUE) + ' ' + Resources.get("err.review.cfg", getFileName()), re, key);
		}
	}

	@Override
	public Short getShort(final String key) {
		try {
			return super.getShort(key);
		}
		catch (final RuntimeException re) {
			throw new ConfigurationException(Resources.get("err.invalid.cfg.number", key, Short.MIN_VALUE, Short.MAX_VALUE) + ' ' + Resources.get("err.review.cfg", getFileName()), re, key);
		}
	}

	@Override
	public short getShort(final String key, final short defaultValue) {
		try {
			return super.getShort(key, defaultValue);
		}
		catch (final RuntimeException re) {
			throw new ConfigurationException(Resources.get("err.invalid.cfg.number", key, Short.MIN_VALUE, Short.MAX_VALUE) + ' ' + Resources.get("err.review.cfg", getFileName()), re, key);
		}
	}

	@Override
	public Byte getByte(final String key) {
		try {
			return super.getByte(key);
		}
		catch (final RuntimeException re) {
			throw new ConfigurationException(Resources.get("err.invalid.cfg.number", key, Byte.MIN_VALUE, Byte.MAX_VALUE) + ' ' + Resources.get("err.review.cfg", getFileName()), re, key);
		}
	}

	@Override
	public byte getByte(final String key, final byte defaultValue) {
		try {
			return super.getByte(key, defaultValue);
		}
		catch (final RuntimeException re) {
			throw new ConfigurationException(Resources.get("err.invalid.cfg.number", key, Byte.MIN_VALUE, Byte.MAX_VALUE) + ' ' + Resources.get("err.review.cfg", getFileName()), re, key);
		}
	}

	@Override
	public Float getFloat(final String key) {
		try {
			return super.getFloat(key);
		}
		catch (final RuntimeException re) {
			throw new ConfigurationException(Resources.get("err.invalid.cfg.number", key, Float.MIN_VALUE, Float.MAX_VALUE) + ' ' + Resources.get("err.review.cfg", getFileName()), re, key);
		}
	}

	@Override
	public float getFloat(final String key, final float defaultValue) {
		try {
			return super.getFloat(key, defaultValue);
		}
		catch (final RuntimeException re) {
			throw new ConfigurationException(Resources.get("err.invalid.cfg.number", key, Float.MIN_VALUE, Float.MAX_VALUE) + ' ' + Resources.get("err.review.cfg", getFileName()), re, key);
		}
	}

	@Override
	public Double getDouble(final String key) {
		try {
			return super.getDouble(key);
		}
		catch (final RuntimeException re) {
			throw new ConfigurationException(Resources.get("err.invalid.cfg.number", key, Double.MIN_VALUE, Double.MAX_VALUE) + ' ' + Resources.get("err.review.cfg", getFileName()), re, key);
		}
	}

	@Override
	public double getDouble(final String key, final double defaultValue) {
		try {
			return super.getDouble(key, defaultValue);
		}
		catch (final RuntimeException re) {
			throw new ConfigurationException(Resources.get("err.invalid.cfg.number", key, Double.MIN_VALUE, Double.MAX_VALUE) + ' ' + Resources.get("err.review.cfg", getFileName()), re, key);
		}
	}

	@Override
	public Character getChar(final String key) {
		try {
			return super.getChar(key);
		}
		catch (final RuntimeException re) {
			throw new ConfigurationException(Resources.get("err.invalid.cfg", key) + ' ' + Resources.get("err.review.cfg", getFileName()), re, key);
		}
	}

	@Override
	public char getChar(final String key, final char defaultValue) {
		try {
			return super.getChar(key, defaultValue);
		}
		catch (final RuntimeException re) {
			throw new ConfigurationException(Resources.get("err.invalid.cfg", key) + ' ' + Resources.get("err.review.cfg", getFileName()), re, key);
		}
	}

//	public static void main(String... args) throws IOException {
//		Properties p = new Properties();
//		InputStream r = RouterLoggerConfiguration.class.getResourceAsStream("/routerlogger.cfg");
//		p.load(r);
//		r.close();
//		System.out.println("Presenti in routerlogger.cfg e non presenti in Preference:");
//		outer: for (String key : p.stringPropertyNames()) {
//			for (Preference preference : Preference.values()) {
//				if (preference.getConfigurationKey().equals(key)) {
//					continue outer;
//				}
//			}
//			System.out.println(key);
//		}
//		System.out.println();
//		System.out.println("Presenti in Preference e non presenti in routerlogger.cfg:");
//		outer: for (Preference preference : Preference.values()) {
//			for (String key : p.stringPropertyNames()) {
//				if (preference.getConfigurationKey().equals(key)) {
//					continue outer;
//				}
//			}
//			System.out.println(preference.getConfigurationKey());
//		}
//	}

}
