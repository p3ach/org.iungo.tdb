package org.iungo.tdb.test;

import static org.junit.Assert.*;

import org.iungo.id.api.ID;
import org.iungo.lifecycle.api.ServiceLifecycle;
import org.iungo.router.api.Router;
import org.iungo.tdb.api.TDBNode;
import org.iungo.tdb.api.TDBNodeContext;
import org.junit.Test;

public class TDBNodeTest {

	@Test
	public void test() {
		final TDBNodeContext tdbNodeContext = new TDBNodeContext();
		final ID id = new ID(TDBNode.class.getSimpleName(), null, null);
		tdbNodeContext.putID(id);
		final TDBNode tdbNode = new TDBNode(tdbNodeContext);
		tdbNode.setState(ServiceLifecycle.STARTED);
	}

}
