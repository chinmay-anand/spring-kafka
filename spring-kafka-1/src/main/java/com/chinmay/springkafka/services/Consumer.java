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
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {
	private static final Logger logger = LoggerFactory.getLogger(Consumer.class);
	
	@KafkaListener(topics = {"users"}, groupId = "group_chinmay")
	public void consume(String message) {
		logger.info(String.format("<<<<<  Consumed message --> %s", message));
	}
}
