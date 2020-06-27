/*
 * Copyright (C) 2020 Chinmay Anand 
 *
 * Unless required by applicable law or agreed to in writing, software 
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * Contact me at LinkedIn regarding the License for the specific language 
 * governing permissions and limitations under the License.
 */

package com.chinmay.springkafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chinmay.springkafka.services.Producer;

// REFER: https://dzone.com/articles/magic-of-kafka-with-spring-boot

@RestController
@RequestMapping(path="/kafka")
public class MyKafkaController {
	
	private Producer producer;

	@Autowired
	public MyKafkaController(Producer producer) {
		this.producer = producer;
	}
	
	@PostMapping(path = "/publish")
	public void sendMessageToKafkaTopic(@RequestParam(name = "message") String message) {
		this.producer.sendMessage(message);
	}
		
}
