/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ams_utilities;

import java.io.InputStream;
import java.io.OutputStream;
import gnu.io.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nandun
 */
public class FingerPrint implements SerialPortEventListener{

    private CommPortIdentifier portIdentifier = null;
    private CommPort commPort = null;
    private BufferedReader in;
    private OutputStream out;
    String inputLine = null;

    public int connect(String portName) throws Exception {
        portIdentifier = CommPortIdentifier.getPortIdentifier(portName);
        if (portIdentifier.isCurrentlyOwned()) {
            return 1;
        } else {
            int timeout = 1000;
            commPort = portIdentifier.open(this.getClass().getName(), timeout);
            if (commPort instanceof SerialPort) {
                SerialPort serialPort = (SerialPort) commPort;
                serialPort.setSerialPortParams(9600, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);

                try{
			in = new BufferedReader(new InputStreamReader(serialPort.getInputStream()));
			out = serialPort.getOutputStream();
			serialPort.addEventListener(this);
			serialPort.notifyOnDataAvailable(true);
			serialPort.notifyOnOutputEmpty(true);
		}
		catch(Exception e){
			System.out.println(e.toString());
		}
            } else {
                return 2;
            }
        }
        return 0;
    }

    public void close() {
        commPort.close();
        System.out.println("Connection closed");
    }

    public void serialEvent(SerialPortEvent evt) {
        if (evt.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
            try {
                do {
                    inputLine = in.readLine();
                    System.out.println(inputLine);
                } while (true);
            } catch (Exception e) {
                //System.err.println(e.toString());
            }
        }
    }//serialEvent

    public void write(String data) {
        System.out.println("Sent: " + data);
        try {
            out.write(data.getBytes());
        } catch (Exception e) {
            System.out.println("Could not write to port");
        }
    }
    
    public String getInputLine(){
        return inputLine;
    }
}
