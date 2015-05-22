package org.iungo.tdb.api;

import org.iungo.context.api.Context;
import org.iungo.node.api.NodeContext;

import com.hp.hpl.jena.tdb.sys.Names;

public class TDBNodeContext extends NodeContext {

	private static final long serialVersionUID = 1L;

	public static final String LOCATION = "Location";
	
	public TDBNodeContext() {
		super();
	}

	public TDBNodeContext(final NodeContext nodeContext) {
		super(nodeContext);
	}

	/**
	 * Return the location, return Names.memName ("--mem--") if null.
	 * @return
	 */
	public String getLocation() {
		return (String) get(LOCATION, new NodeContext.Go() {
			@Override
			public Object go(final Context<String, Object> context) {
				return Names.memName;
			}
		});
	}
	
	public void setLocation(final String location) {
		put(LOCATION, location);
	}
}
