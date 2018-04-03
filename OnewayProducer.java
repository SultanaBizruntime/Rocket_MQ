import org.apache.rocketmq.client.producer.DefaultMQProducer;

import org.apache.rocketmq.common.message.Message;

import org.apache.rocketmq.remoting.common.RemotingHelper;



public class OnewayProducer {

	 public static void main(String[] args) throws Exception{

	        DefaultMQProducer producer = new DefaultMQProducer("ExampleProducerGroup");

	        producer.start();

	        for (int i = 0; i < 100; i++) {

	            Message msg = new Message("TopicTest" /* Topic */,

	                "TagA" /* Tag */,

	                ("Hello RocketMQ " +

	                    i).getBytes(RemotingHelper.DEFAULT_CHARSET) /* Message body */

	            );

	            producer.sendOneway(msg);



	        }

	        producer.shutdown();

	    }



}