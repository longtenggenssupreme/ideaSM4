import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.soap.SOAPConstants;

import javax.xml.namespace.QName;
import java.net.URL;

public class Longteng {

    public static void main(String[] args) {
        TestWebserviceHelloWorld3();
        //TestSM334455();
        /*try {

            String json = "{\"name\":\"Marydon\",\"website\":\"http://www.cnblogs.com/Marydon20170307\"}";
            json = "1234567890中华人民共和国abcdefghijklmnopqrstuvwxyz";
            System.out.println("国密SM4加密解密：");
            // 自定义的32位16进制密钥
//            String key = "86C63180C2806ED1F47B859DE501215B";
            String key = "1234567890123456";
            String cipher = Sm4Util.encryptEcb(key, json);
            System.out.println("国密SM4加密解密：\r\n密钥：" + key + " \n加密内容：" + json + " \n加密后v" + cipher);

            //System.out.println(cipher);//c7JUMyMa7R4pE7xAztUy6I9rQhu6rr8bqerB1pX3ZbhZEVNIrw86Jr8sQuqT5VJLkOc2X6couGoPTzM7MJTnVg
            //比对加密解密信息
            System.out.println(Sm4Util.verifyEcb(key, cipher, json));// true
            json = Sm4Util.decryptEcb(key, cipher);
            System.out.println("国密SM4加密解密：\n密钥：" + key + " \n加密内容：" + cipher + " \n解密后：" + json);

            //System.out.println(json);
        } catch (Exception e) {
            e.printStackTrace();
        }*/

    }

    /*测试
     * */
    public static void TestSM334455() {
        try {

            String json = "{\"name\":\"Marydon\",\"website\":\"http://www.cnblogs.com/Marydon20170307\"}";
            json = "1234567890中华人民共和国abcdefghijklmnopqrstuvwxyz";
            System.out.println("国密SM4加密解密：");
            // 自定义的32位16进制密钥
//            String key = "86C63180C2806ED1F47B859DE501215B";
            String key = "1234567890123456";
            String cipher = Sm4Util.encryptEcb(key, json);
            System.out.println("国密SM4加密解密：\r\n密钥：" + key + " \n加密内容：" + json + " \n加密后v" + cipher);

            //System.out.println(cipher);//c7JUMyMa7R4pE7xAztUy6I9rQhu6rr8bqerB1pX3ZbhZEVNIrw86Jr8sQuqT5VJLkOc2X6couGoPTzM7MJTnVg
            //比对加密解密信息
            System.out.println(Sm4Util.verifyEcb(key, cipher, json));// true
            json = Sm4Util.decryptEcb(key, cipher);
            System.out.println("国密SM4加密解密：\n密钥：" + key + " \n加密内容：" + cipher + " \n解密后：" + json);

            //System.out.println(json);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void TestWebserviceHelloWorld3() {
        try {
            //String url = "http://localhost:8012/WebService1.asmx";
            //String namespace = "http://tempuri.org/";
            Service service = new Service();
            Call call = (Call) (new Service()).createCall();
            call.setTargetEndpointAddress(new URL("http://localhost:8012/WebService1.asmx"));
            call.setOperationName(new QName("http://tempuri.org/", "HelloWorld3"));
            call.setTimeout(30000);
            call.setUseSOAPAction(true);
            call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
            //解决 提示System.Web.Services.Protocols.SoapException: 服务器未能识别 HTTP 头 SOAPAction 的值: 。的错误问题
            // SOAP 1.1 必须添加SOAPAction，SOAP 1.2 则不能添加SOAPAction
            call.setSOAPActionURI("http://tempuri.org/HelloWorld3");
            String re = (String) call.invoke(new String[]{"1", "pass"});
            System.out.println(re);

            //Call call=(Call)(new Service()).createCall();
            //call.setTargetEndpointAddress(new URL("http://127.0.0.1:7001/hnCardService/services/CardService"));
            //call.setOperationName(new QName("http://ws.apache.org/axis2","getCard"));
            //call.setTimeout(30000);
            //String re=(String)call.invoke(new String[]{"user","pass","F20000015","420503198104191819","周玉磊","440200"});
            //System.out.println(re);
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }

    public static void GetStudent() {
        try {
            String url = "http://localhost:9999/WebService.asmx";
            String namespace = "http://tempuri.org/";
            Service service = new Service();
            Call call = (Call) service.createCall();
            QName qname = new QName(namespace, "GetdbData"); //设置命名空间和需要调用的方法名
            call.setOperationName(qname);
            call.setTargetEndpointAddress(url);
            call.setSOAPActionURI(namespace + "GetdbData");
            call.addParameter(new QName(namespace, "Name"), org.apache.axis.encoding.XMLType.XSD_STRING, javax.xml.rpc.ParameterMode.IN);// 接口的参数
            call.setReturnType(org.apache.axis.encoding.XMLType.XSD_STRING);//设置返回类型
            String result = (String) call.invoke(new Object[]{"Tom"});
            System.out.println("结果: \n" + result);
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }

}


