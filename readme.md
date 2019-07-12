##### Pre requisites

Clone and run this [repo](https://github.com/ntarunmenon/springbootouthserver) to set up an OAuth server

##### Back ground Info

An implementation of an oAuth Server using spring boot using this brilliant [tutorial](https://developer.okta.com/blog/2019/03/12/oauth2-spring-security-guide) by Okta

If you dont know what OAuth is [watch this](https://www.youtube.com/watch?v=996OiexHze0&t=2794s) by Okta again. 


##### Explanation of what actually happened

- Type in http://localhost:8082/ and click on login
- Request is redirected to http://localhost:8082/securedPage
- However we are not authenticated, so we are redirected to http://localhost:8082/oauth2/authorization/custom-client
- Now since this is an oAuth the request will be reidrected to the resource server

```
http://localhost:8081/auth/oauth/authorize?response_type=code
 &client_id=R2dpxQ3vPrtfgF72
 &scope=user_info&
 state=ChxO9-qTwXJTMk7hGS_uSnKOoRdoKdKjLBthZs4E-9Y%3D
 &redirect_uri=http://localhost:8082/login/oauth2/code/

``` 
- The Resource server in turn sends the browser to the authentication end point   http://localhost:8081/auth/login
- Once the user enters the user name and password then we are send back to the redirect URL with an access token
In this case the access token is `ghwekt`

```
http://localhost:8082/login/oauth2/code/?
code=ghwekt&
state=ChxO9-qTwXJTMk7hGS_uSnKOoRdoKdKjLBthZs4E-9Y%3D
```  
- The app will now back a background request to the authorisation server using the property `authorization-uri: http://localhost:8081/auth/oauth/authorize`
and the client-secret in `client-secret: fDw7Mpkk5czHNuSRtmhGmAGL42CaxQB9`


 






