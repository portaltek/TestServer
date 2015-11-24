package org.portalapps.webapp.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.tiles.Attribute;
import org.apache.tiles.Definition;
import org.apache.tiles.definition.DefinitionsFactory;
import org.apache.tiles.request.Request;

public final class TilesDefinitionsConfig implements DefinitionsFactory {

	private static final Map<String, Definition> tilesDefinitions = new HashMap<String, Definition>();
	private static final Attribute BASE_TEMPLATE = new Attribute("/WEB-INF/views/layout/defaultLayout.jsp");

	@Override
	public Definition getDefinition(String name, Request tilesContext) {
		return tilesDefinitions.get(name);
	}

	private static void addDefaultLayoutDef(String name, String title, String body) {
		Map<String, Attribute> attributes = new HashMap<String, Attribute>();

		attributes.put("title", new Attribute(title));
		attributes.put("header", new Attribute("/WEB-INF/views/layout/header.jsp"));
		// attributes.put("menu", new
		// Attribute("/WEB-INF/views/layout/menu.jsp"));
		attributes.put("body", new Attribute(body));
		attributes.put("footer", new Attribute("/WEB-INF/views/layout/footer.jsp"));

		tilesDefinitions.put(name, new Definition(name, BASE_TEMPLATE, attributes));
	}

	/**
	 * <code>Add Apache tiles definitions</code>
	 */
	public static void addDefinitions() {
		addDefaultLayoutDef("home", "Home", "/WEB-INF/views/home.jsp");
	}
}