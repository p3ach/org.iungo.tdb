package org.iungo.tdb.api;

import org.iungo.logger.api.ClassLogger;
import org.iungo.logger.api.Logger;
import org.iungo.logger.api.Loggers;
import org.iungo.message.api.Message;
import org.iungo.node.api.NodeContext;
import org.iungo.rdf.api.AbstractDatasetNode;
import org.iungo.result.api.Result;

import com.hp.hpl.jena.sparql.core.DatasetGraph;
import com.hp.hpl.jena.tdb.TDBFactory;

public class TDBNode extends AbstractDatasetNode {
	
	private static final ClassLogger logger = Loggers.valueOf(TDBNode.class);
	static {
		logger.setLevel(Logger.DEBUG);
	}

	private final TDBNodeContext tdbNodeContext;

	private final DatasetGraph datasetGraph;
	
	public TDBNode(final NodeContext nodeContext) {
		super(nodeContext);
		
		tdbNodeContext = new TDBNodeContext(nodeContext);
		
		datasetGraph = TDBFactory.createDatasetGraph(tdbNodeContext.getLocation());
	}

	@Override
	public Result receive(Message message) {
		logger.debug(message.toString());
		return super.receive(message);
	}

	@Override
	protected Result beforeClose() {
		try {
			datasetGraph.close();
			return super.beforeClose();
		} catch (final Exception exception) {
			return Result.valueOf(exception);
		}
	}


}
