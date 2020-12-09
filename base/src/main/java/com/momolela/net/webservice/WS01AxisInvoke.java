package com.momolela.net.webservice;

import org.apache.axis.Constants;
import org.apache.axis.client.Call;
import org.apache.axis.client.Service;

import javax.xml.namespace.QName;
import javax.xml.rpc.ParameterMode;
import java.net.URL;

public class WS01AxisInvoke {

    public static void main(String[] args) {
        String soapAction = "http://ws.access.hai/";
        // 你的webservice地址
        String endpoint = "http://10.8.2.162:9528/hai/WebServiceEntry?wsdl";
        Service service = new Service();
        try {
            Call call = (Call) service.createCall();
            call.setTimeout(new Integer(60000));
            call.setTargetEndpointAddress(new URL(endpoint));
            // 你需要远程调用的方法
            call.setOperationName(new QName(soapAction, "invoke"));

            // 方法参数，如果没有参数请无视
            // call.addParameter(new QName(soapaction,"ODS_updatePrescriptionState"), XMLType.XSD_STRING, ParameterMode.IN);
            // call.addParameter(new QName(soapaction,""), XMLType.XSD_STRING, ParameterMode.IN);
            // call.addParameter(new QName(soapaction,""), XMLType.XSD_STRING, ParameterMode.IN);
            // call.addParameter(new QName(soapaction,"<BSXml><MsgHeader><Organization>1</Organization><ServiceType>service</ServiceType><Sender>PTS</Sender><MsgType>ODS_03040009</MsgType><MsgVersion></MsgVersion></MsgHeader><MsgBody><PrescriptionLists><PrescriptionList><VisitOrganization>1</VisitOrganization><HosArea>0</HosArea><PatientType>01</PatientType><RecipeNumber>2086</RecipeNumber><AuditStatus>0</AuditStatus><AuditOpinion>null</AuditOpinion><SupplementType>0</SupplementType><AuditDoctorId/><AuditDoctor/></PrescriptionList></PrescriptionLists></MsgBody></BSXml>"), XMLType.XSD_STRING, ParameterMode.IN);

            // 设置返回类型，对方接口返回的json，我就用string接收了,自定义类型另贴一个代码
            // call.setReturnType(XMLType.XSD_STRING);

            // 调用方法并传递参数，没有参数的话： call.invoke(new Object[] { null});
            call.setEncodingStyle("UTF-8");
            call.addParameter("service", Constants.XSD_STRING, String.class, ParameterMode.IN);
            call.addParameter("urid", Constants.XSD_STRING, String.class, ParameterMode.IN);
            call.addParameter("pwd", Constants.XSD_STRING, String.class, ParameterMode.IN);
            call.addParameter("parameter", Constants.XSD_STRING, String.class, ParameterMode.IN);

//            for (int i = 0; i < 10; i++) {
            long s = System.currentTimeMillis();
            String result = (String) call.invoke(new Object[]{"ODS_ListAppointmentWait", "", "", "<BSXml><MsgHeader><Organization>1</Organization><Sender>GOL</Sender><ServiceType>service</ServiceType><MsgType>ODS_02040016</MsgType><MsgVersion>3.3</MsgVersion></MsgHeader><MsgBody><Query><VisitOrganization>1</VisitOrganization><QueryType>2</QueryType><MedicalCardIdLists><MedicalCardIdList><MedicalCardType></MedicalCardType><MedicalCardId></MedicalCardId></MedicalCardIdList></MedicalCardIdLists><SourcePatientIdLists><SourcePatientIdList><sourcePatientId></sourcePatientId></SourcePatientIdList></SourcePatientIdLists><IdCardLists><IdCardList><IdCardCode>01</IdCardCode><IdCard>110101199003070679</IdCard></IdCardList><IdCardList><IdCardCode>01</IdCardCode><IdCard>340521198508194410</IdCard></IdCardList><IdCardList><IdCardCode>01</IdCardCode><IdCard>211202199604270568</IdCard></IdCardList><IdCardList><IdCardCode>01</IdCardCode><IdCard>410102196503070097</IdCard></IdCardList><IdCardList><IdCardCode>01</IdCardCode><IdCard>110101199007073455</IdCard></IdCardList><IdCardList><IdCardCode>01</IdCardCode><IdCard>110101199007074917</IdCard></IdCardList><IdCardList><IdCardCode>01</IdCardCode><IdCard>150702199003070034</IdCard></IdCardList><IdCardList><IdCardCode>01</IdCardCode><IdCard>440103199303074638</IdCard></IdCardList><IdCardList><IdCardCode>01</IdCardCode><IdCard>140105200803073954</IdCard></IdCardList><IdCardList><IdCardCode>01</IdCardCode><IdCard>110101199503077877</IdCard></IdCardList></IdCardLists><AppointmentStatus></AppointmentStatus><OutpatientType>101</OutpatientType><AppointBeginDateTime></AppointBeginDateTime><AppointEndDateTime></AppointEndDateTime><PageNo>1</PageNo><PageSize>20</PageSize></Query></MsgBody></BSXml>"});
            long e = System.currentTimeMillis();
            System.out.println(result);
            System.out.println(e - s);
//            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}