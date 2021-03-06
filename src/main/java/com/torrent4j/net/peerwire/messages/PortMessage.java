package com.torrent4j.net.peerwire.messages;

import io.netty.buffer.ByteBuf;

import com.torrent4j.net.peerwire.AbstractPeerWireMessage;

public class PortMessage extends AbstractPeerWireMessage {
	public static final int MESSAGE_ID = 0x09;

	public int listenPort;

	public PortMessage() {
		super(MESSAGE_ID);
	}

	public PortMessage(int listenPort) {
		super(MESSAGE_ID);
		this.listenPort = listenPort;
	}

	@Override
	public void writeImpl(ByteBuf buffer) {
		buffer.writeInt(listenPort);
	}

	@Override
	public void readImpl(ByteBuf buffer) {
		listenPort = buffer.readInt();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PORT [listenPort=" + listenPort + "]";
	}
}
