package io.battlerune.net.fs;

import java.nio.charset.Charset;
import java.util.logging.Logger;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.util.ResourceLeakDetector;
import io.netty.util.ResourceLeakDetector.Level;

/**
 * The main class of the FileServer. Services are started here..
 * 
 * @author Professor Oak
 * 
 *         Credits to:
 * @author Graham
 * @author Nikki For references from their update-server in the Apollo source.
 */
public final class FileServer {

	/**
	 * The port for the file-server service.
	 */
	public static final int FILE_SERVER_PORT = 43596;

	/**
	 * The opcode for a JagGrab request.
	 */
	public static final byte JAGGRAB_REQUEST_OPCODE = 1;

	/**
	 * The opcode for an OnDemand request.
	 */
	public static final byte ONDEMAND_REQUEST_OPCODE = 2;

	/**
	 * The character set used in a JagGrab request.
	 */
	public static final Charset JAGGRAB_CHARSET = Charset.forName("US-ASCII");

	/**
	 * The maximum length of an ondemand file chunk, in bytes.
	 */
	public static final int MAX_ONDEMAND_CHUNK_LENGTH_BYTES = 1000;

	/**
	 * The logger for this class.
	 */
	private static final Logger logger = Logger.getLogger(FileServer.class.getName());

	/**
	 * Starts the FileServer system.
	 * 
	 * @throws Exception
	 *             if an error occurs.
	 */
	public static void init() throws Exception {

		logger.info("Starting File-Server service on port " + FileServer.FILE_SERVER_PORT + "..");

		// Bind service..
		ResourceLeakDetector.setLevel(Level.DISABLED);
		EventLoopGroup loopGroup = new NioEventLoopGroup();
		ServerBootstrap bootstrap = new ServerBootstrap();
		bootstrap.group(loopGroup).channel(NioServerSocketChannel.class).childHandler(new PipelineFactory())
				.bind(FileServer.FILE_SERVER_PORT).syncUninterruptibly();

		logger.info("File-Server has been initialised on port " + FileServer.FILE_SERVER_PORT + ".");
	}
}