package br.com.sbx.common.phonetization;

import java.util.List;
import java.util.Map;

import br.com.sbx.common.lang.StringUtils;

import static java.util.Map.entry;

import java.util.ArrayList;
import java.util.Arrays;

public class PhonetizerReplacements {
	/**
	 * 
	 */
	private final Map<String, String> brLetterReplacements = Map.ofEntries(
			entry("AGA","H")
			, entry("BE","B")
			, entry("CA","K")
			, entry("CE","C")
			, entry("DABLIU","W")
			, entry("EFE","F")
			, entry("ELE","L")
			, entry("EME","M")
			, entry("ENE","N")
			, entry("ERRE","R")
			, entry("ESSE","S")
			, entry("GE","G")
			, entry("IPSILOM","Y")
			, entry("IPSILON","Y")
			, entry("JOTA","J")
			, entry("PE","P")
			, entry("QUE","Q")
			, entry("TE","T")
			, entry("VE","V")
			, entry("XIS","X")
			, entry("ZE","Z"));

	/**
	 * 
	 */
	private final Map<String, String> brNumberReplacements = Map.ofEntries(
		    entry("k1", "v1")
		    , entry("ZERO","0000")
			, entry("UM","0001") 
			, entry("HUM","0001")
			, entry("DOIS","0002")
			, entry("TRES","0003")
			, entry("TREIS","0003")
			, entry("TREZ","0003") 
			, entry("QUATRO","0004")
			, entry("CINCO","0005")
			, entry("SEIS","0006")
			, entry("SETE","0007")
			, entry("OITO","0008")
			, entry("NOVE","0009")
			, entry("DEZ","0010")
			, entry("ONZE","0011")
			, entry("DOZE","0012")
			, entry("TREZE","0013") 
			, entry("CATORZE","0014")
			, entry("QUATORZE","0014")
			, entry("QUINZE","0015")
			, entry("DEZESSEIS","0016")
			, entry("DEZESSETE","0017") 
			, entry("DEZOITO","0018")
			, entry("DEZENOVE","0019")
			, entry("VINTE","0020")
			, entry("TRINTA","0030")
			, entry("QUARENTA","0040") 
			, entry("CINCOENTA","0050")
			, entry("CINQUENTA","0050")
			, entry("SESSENTA","0060")
			, entry("SETENTA","0070")
			, entry("OITENTA","0080")
			, entry("NOVENTA","0090")
			, entry("CEM","0100")
			, entry("CENTO","0100")
			, entry("DUZENTOS","0200")
			, entry("TRESENTOS","0300")
			, entry("TREZENTOS","0300") 
			, entry("QUATROCENTOS","0400")
			, entry("QUINHENTOS","0500")
			, entry("SEICENTOS","0600")
			, entry("SEISENTOS","0600")
			, entry("SEISCENTOS","0600")
			, entry("SETECENTOS","0700")
			, entry("OITOCENTOS","0800")
			, entry("NOVECENTOS","0900")
			
			, entry("I","0001") 
			, entry("II","0002")
			, entry("III","0003")
			, entry("IV","0004")
			, entry("IX","0009") 
			, entry("V","0005") 
			, entry("VI","0006")
			, entry("VII","0007") 
			, entry("VIII","0008")
			, entry("X","0010") 
			, entry("XI","0011") 
			, entry("XII","0012") 
			, entry("XIII","0013") 
			, entry("XIV","0014")
			, entry("XIX","0019")
			, entry("XV","0015")
			, entry("XVI","0016")
			, entry("XVII","0017")
			, entry("XVIII","0018")
			, entry("XX","0020")
			, entry("XXI","0021") 
			, entry("XXII","0022") 
			, entry("XXIII","0023") 
			, entry("XXIV","0024")
			, entry("XXIX","0029") 
			, entry("XXV","0025")
			, entry("XXVI","0026")
			, entry("XXVII","0027")
			, entry("XXVIII","0028")
			, entry("XXX","0030") 
			, entry("XXXI","0031"));
	
	/**
	 * 
	 * @param phrase
	 * @return
	 */
	public List<String> brWordsNumbers(String phrase) {
		List<String> words = new ArrayList<String>(Arrays.asList(phrase.split(" ")));
		
		replaces(words, this.brLetterReplacements);
		replaces(words, this.brNumberReplacements);
		
		int sum = 0;

		words.removeIf(word -> word.toUpperCase().equals("E"));

		for (int i = 0; i < words.size(); i++) {

			if ("MIL".equals(words.get(i))) {
				if (sum == 0) {
					sum = 1000;
				} else {
					sum = sum * 1000;
					words.remove(i);
					i--;
				}
			} else {
				Integer value = null;

				try {
					value = Integer.parseInt(words.get(i).toString());
				} catch (NumberFormatException e) {

				}

				if (value != null) {
					if (sum != 0) {
						words.remove(i - 1);
						i--;
					}
					sum += value;
				} else {
					if (sum != 0) {
						words.set(i - 1, "" + sum);
					}
					sum = 0;
				}
			}

			words.set(i, StringUtils.removeEqualChars(words.get(i)));
		}
		
		if(sum != 0){
			words.set(words.size() - 1, "" + sum);
		}
		
		return words;
	}

	/**
	 * 
	 * @param words
	 * @param map
	 */
	public static void replaces(List<String> words, Map<String, String> map) {
		words.stream().forEach(word -> {
			String rep = map.get(word);
			if(rep != null){
				word = rep;
			}
		});
	}
}
