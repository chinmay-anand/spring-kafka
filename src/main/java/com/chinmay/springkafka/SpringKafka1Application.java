/*
 * Copyright (C) 2020 Chinmay Anand 
 *
 * Unless required by applicable law or agreed to in writing, software 
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * Contact me at LinkedIn regarding the License for the specific language 
 * governing permissions and limitations under the License.
 */

package com.chinmay.springkafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringKafka1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringKafka1Application.class, args);
		System.out.println("\n\nHOW TO TEST (Change the message value in postman to see result");
		System.out.println("---------------\n");
		System.out.println("Open POSTMAN application and post a sample message using the url http://localhost:9000/kafka/publish?message=My first message\n");
		System.out.println("On console Producer prints: >>>>> Producting message --> My first message\n");
		System.out.println("On console Consumer prints: <<<<<  Consumed message --> My first message\n");
	}

}
