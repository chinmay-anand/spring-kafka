/*
 * Copyright (C) 2020 Chinmay Anand 
 *
 * Unless required by applicable law or agreed to in writing, software 
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * Contact me at LinkedIn regarding the License for the specific language 
 * governing permissions and limitations under the License.
 */

package com.chinmay.springkafka.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {
	private static final Logger logger = LoggerFactory.getLogger(Producer.class);
	private static final String TOPIC = "users";
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	public void sendMessage(String message)
	{
		logger.info(String.format(">>>>> Producting message --> %s", message));
		this.kafkaTemplate.send(TOPIC, message);
	}
}
