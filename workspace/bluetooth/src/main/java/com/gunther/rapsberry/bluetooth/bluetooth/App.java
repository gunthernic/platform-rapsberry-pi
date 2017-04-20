package com.gunther.rapsberry.bluetooth.bluetooth;

import java.util.ArrayList;
import java.util.List;

import javax.bluetooth.DiscoveryAgent;
import javax.bluetooth.LocalDevice;
import javax.bluetooth.RemoteDevice;

/**
 * Hello world!
 *
 */
public class App {
	public static Object lock = new Object();
	public static List<RemoteDevice> devices = new ArrayList<RemoteDevice>();

	public static void main(String[] args) {
		System.out.println("Hello World!");

		try {
			LocalDevice localDevice = LocalDevice.getLocalDevice();

			DiscoveryAgent agent = localDevice.getDiscoveryAgent();

			agent.startInquiry(DiscoveryAgent.GIAC, new MyDiscoveryListener());

			try {
				synchronized (lock) {
					lock.wait();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Device Inquiry Completed. ");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}