/*
 * Internationalization support table
 * 
 * Currently supports English and Germany
 */

package com.javatunes.bean;

import java.util.HashMap;
import java.util.Map;

public class Lang {
	
	// Map for language tag
	static final Map<String, String> langTable = new HashMap<String, String>();
	
	public void loadLang(String lang) {
		
		// English support
		if(lang.equals("en")) {
			
			// Login
			langTable.put("login.welcome", "Welcome to JavaTunes! <br>Your online music store.");
			langTable.put("login.pleaselogin", "Please login");
			langTable.put("login.username", "Username");
			langTable.put("login.password", "Password");
			langTable.put("login.signin", "Sign In");
			langTable.put("login.timeout", "You are not logged in or session is timeout, please login.");
			langTable.put("login.notamember", "Not a member?");
			langTable.put("login.signup", "Sign Up");
			
			// Header
			langTable.put("header.hello", "Hello");
			langTable.put("header.largest", "Largest Collection of Music Anywhere!");
			
			// Index
			langTable.put("index.seebelow", "See below popular musics you may interested to");
			langTable.put("index.or", "Or");
			langTable.put("index.searchfortunes", "Search for tunes");
			
			langTable.put("index.id", "ID");
			langTable.put("index.name", "Name");
			langTable.put("index.artist", "Artist");
			langTable.put("index.releasedate", "Release Date");
			langTable.put("index.listprice", "List Price");
			langTable.put("index.yourprice", "Your Price");
			langTable.put("index.action", "Action");
			langTable.put("index.addtocart", "Add to Cart");
			langTable.put("index.added", "added");
			
			// Search Header
			langTable.put("searchheader.keywordsearch", "JavaTunes Keyword CD Database Search");
			langTable.put("searchheader.searchwithkeyword", "Search with Keyword");
			langTable.put("searchheader.search", "Search");
			
			// Search Result
			langTable.put("searchresult.searchresult", "Search results for keyword:");
			
			// Shopping Cart
			langTable.put("shoppingcart.yourshoppingcart", "Your Shopping Cart");
			langTable.put("shoppingcart.nothing", "You do not have anything in your cart");
			langTable.put("shoppingcart.title", "Title");
			langTable.put("shoppingcart.quantity", "Quantity");
			langTable.put("shoppingcart.pricebeforetax", "Price Before Tax");
			langTable.put("shoppingcart.tax", "Tax");
			langTable.put("shoppingcart.totalprice", "Total Price");
			langTable.put("shoppingcart.checkout", "Check Out");
			langTable.put("shoppingcart.shopformore", "Shop for More");
			
			langTable.put("shoppingcart.searchandshop", "Search and Shop");
			
		// Germany support
		} else if(lang.equals("de")){
			// Login
			langTable.put("login.welcome", "Willkommen auf JavaTunes! <br>Ihre Online-Musikladen.");
			langTable.put("login.pleaselogin", "Bitte loggen Sie sich ein");
			langTable.put("login.username", "Benutzername");
			langTable.put("login.password", "Kennwort");
			langTable.put("login.signin", "Anmelden");
			langTable.put("login.timeout", "Sie sind nicht eingeloggt oder Session-Timeout, bitte anmelden.");
			langTable.put("login.notamember", "Noch kein Mitglied?");
			langTable.put("login.signup", "Registrieren");
			
			// Header
			langTable.put("header.hello", "hallo");
			langTable.put("header.largest", "Größte Sammlung von Musik überall!");
			
			// Index
			langTable.put("index.seebelow", "Siehe unten beliebt Musiken Sie interessieren könnten");
			langTable.put("index.or", "oder");
			langTable.put("index.searchfortunes", "Suche nach Melodien");
			
			langTable.put("index.id", "ID");
			langTable.put("index.name", "Name");
			langTable.put("index.artist", "Künstler");
			langTable.put("index.releasedate", "Erscheinungsdatum");
			langTable.put("index.listprice", "Listenpreis");
			langTable.put("index.yourprice", "Ihr Preis");
			langTable.put("index.action", "Handlung");
			langTable.put("index.addtocart", "In den Warenkorb");
			langTable.put("index.added", "hinzugefügt");
			
			// Search Header
			langTable.put("searchheader.keywordsearch", "JavaTunes Keyword CD Datenbankrecherche");
			langTable.put("searchheader.searchwithkeyword", "Suche nach Stichworten");
			langTable.put("searchheader.search", "Suchen");
			
			// Search Result
			langTable.put("searchresult.searchresult", "Suchergebnisse für Stichwort:");
			
			// Shopping Cart
			langTable.put("shoppingcart.yourshoppingcart", "Ihr Warenkorb");
			langTable.put("shoppingcart.nothing", "Sie haben noch nichts in Ihren Warenkorb");
			langTable.put("shoppingcart.title", "Titel");
			langTable.put("shoppingcart.quantity", "Menge");
			langTable.put("shoppingcart.pricebeforetax", "Preis vor Steuern");
			langTable.put("shoppingcart.tax", "MwSt.");
			langTable.put("shoppingcart.totalprice", "Gesamtpreis");
			langTable.put("shoppingcart.checkout", "Abreise");
			langTable.put("shoppingcart.shopformore", "Geschäft für mehr");
			
			langTable.put("shoppingcart.searchandshop", "Suchen und Shop-");
			
		}
	}
	
	/**
	 * get the language support tag via given label
	 * @param tag id
	 * @return label by given tag id
	 */
	public String getLang(String tag) {
		String t = "text";
		t = langTable.get(tag);
		return t;
	}
	
	/**
	 * get the language suppport table
	 * @return the language support table
	 */
	public Map<String, String> getMap() {
		return langTable;
	}
}
