package com.zk.spring.proxy;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Test666 {


    private static Logger logger= LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);



    public static void main(String[] args) throws Exception {
        Maotai maotai=new Maotai();
        MyInvocationHandler myInvocationHandler=new MyInvocationHandler();
        myInvocationHandler.setSell(maotai);
        Sell proxy = (Sell) myInvocationHandler.getProxy();
        proxy.sell();
    }

    public void testLog(){
        logger.debug ( "debug message" ) ;
        logger.info ( "info message"  ) ;
        logger.warn ( "warn message"  ) ;
        logger.error ( "error message" ) ;
        try{
//           int i= 1/0;
            String str = null;
            System.out.println(str.toString());
        }catch (Exception e){
            e.printStackTrace();
            logger.error ( e.getMessage()) ;
            logger.error("localizaizedMessage : {}", e.getLocalizedMessage());
            logger.error("exception message : {}", e.getMessage());
            logger.error("exception cause : {}", e.getCause());
            logger.error("exception suppressed : {}", e.getSuppressed());
            //异常输出
//            logger.error("exception toString and track space : {}", "\r\n" + e);
            logger.error(e.toString());
            logger.error("---------------------------------------------");

        }
    }
}
