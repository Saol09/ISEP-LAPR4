package eapli.base.utils;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * The type Tcp message utils.
 */
public class TCPMessageUtils {
    /**
     * Write message with data.
     *
     * @param code       the code
     * @param dataToSend the data to send
     * @param sOut       the s out
     * @throws IOException the io exception
     */
// writeMessageWithData ((byte ) 3, "askndf", sOut)
    public static void writeMessageWithData(byte code, String dataToSend, DataOutputStream sOut) throws IOException {
        byte[] data = new byte[300];
        data = dataToSend.getBytes();
        byte[] message = {(byte) 0, code, (byte) dataToSend.length(), (byte) 0};
        sOut.write(message, 0, 4);
        sOut.write(data,0,dataToSend.length());
        sOut.flush();
    }


    /**
     * Gets data from message.
     *
     * @param message the message
     * @param sIn     the s in
     * @return the data from message
     * @throws IOException the io exception
     */
    public static String getDataFromMessage(byte[] message, DataInputStream sIn) throws IOException {
        String data;

        int dataLength = message[2] + 256 * message[3];
        if(dataLength != 0) {
            byte[] messageData = new byte[dataLength];
            sIn.read(messageData,0,dataLength);
            data = new String(messageData, 0, dataLength);
            return data;
        } else {
            throw new UnsupportedOperationException("There's no data!");
        }
    }

    public static void sendTestRequest(DataOutputStream sOutData) throws IOException {
        byte[] testRequest = {(byte) 0, (byte) 0, (byte) 0, (byte) 0};
        sOutData.write(testRequest);
        sOutData.flush();
    }

    public static void sendEndRequest(DataOutputStream sOutData) throws IOException {
        byte[] endRequest = {(byte) 0, (byte) 1, (byte) 0, (byte) 0};
        sOutData.write(endRequest);
        sOutData.flush();
    }

}
