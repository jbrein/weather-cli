# Weather Command Line Application
This application is a CLI, constructed entirely with Java and using RestTemplate, for the purpose of consuming the openweathermap.org API. For the sake of simplicity, all zipcodes are assumed to be within the United States.
## NOTE
The application uses a constant called **API_KEY** inside the WeatherServices class within the services package. Currently it is set to *"Your API Key here!"*. To have the application launch successfully, you must visit https://home.openweathermap.org/users/sign_up to get a free api key and replace the contents of the string.
## Instructions
* When prompted, user should enter their zipcode. The parameters being a 5 digit string containing only numbers.
* The application then outputs the following:
  * The user's city
  * The user's latitude and longitude
  * The current temperature
  * The current weather
  * What the temperature feels like due to additional factors
  * If the temperature is below a certain threshold, an additional message is displayed