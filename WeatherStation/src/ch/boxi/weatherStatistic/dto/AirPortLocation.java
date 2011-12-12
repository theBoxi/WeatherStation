package ch.boxi.weatherStatistic.dto;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class AirPortLocation extends Location {
	//http://de.wikipedia.org/wiki/Liste_der_Flugh%C3%A4fen_in_der_Schweiz
	public static final Map<String, AirPortLocation> locations;
	public static final AirPortLocation LFSB = new AirPortLocation("LFSB", "BSL", "Basel-Mühlhausen");
	public static final AirPortLocation LSZB = new AirPortLocation("LSZB", "BRN", "Bern-Belp");
	public static final AirPortLocation LSZS = new AirPortLocation("LSZS", "SMV", "Engadin");
	public static final AirPortLocation LSGG = new AirPortLocation("LSGG", "GVA", "Genf");
	public static final AirPortLocation LSZG = new AirPortLocation("LSZG", "ZHI", "Grenchen");
	public static final AirPortLocation LSZA = new AirPortLocation("LSZA", "LUG", "Lugano-Agno");
	public static final AirPortLocation LSGS = new AirPortLocation("LSGS", "SIR", "Sitten");
	public static final AirPortLocation LSZR = new AirPortLocation("LSZR", "ACH", "St. Gallen-Altenrhein");
	public static final AirPortLocation LSZH = new AirPortLocation("LSZH", "ZRH", "Zürich Kloten");
	
	private String icaoCode;
	private String iataCode;
	
	static{
		Map<String, AirPortLocation> tmp = new HashMap<String, AirPortLocation>();
		tmp.put(LFSB.getIcaoCode(), LFSB);
		tmp.put(LSZB.getIcaoCode(), LSZB);
		tmp.put(LSZS.getIcaoCode(), LSZS);
		tmp.put(LSGG.getIcaoCode(), LSGG);
		tmp.put(LSZG.getIcaoCode(), LSZG);
		tmp.put(LSZA.getIcaoCode(), LSZA);
		tmp.put(LSGS.getIcaoCode(), LSGS);
		tmp.put(LSZR.getIcaoCode(), LSZR);
		tmp.put(LSZH.getIcaoCode(), LSZH);
		locations = Collections.unmodifiableMap(tmp);
	}
	
	public AirPortLocation(String icaoCode, String iataCode, String name) {
		super(name);
		this.iataCode = iataCode;
		this.icaoCode = icaoCode;
	}

	public String getIcaoCode() {
		return icaoCode;
	}
}
