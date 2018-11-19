# Thoth RestTemplate

Research on Spring `RestTemplate` calling a REST endpoint.

## thoth-resttemplate-00

This contains an `application-mike.properties` file which
is ignored by Git and not committed to GitHub since it
contains properties to remain private.

## thoth-resttemplate-01-it_works

Using `RestTemplate` to call a test REST endpoint that is publically available
on the Internet. 

**NOTE** If the connection requires a proxy, manually configure the proxy
in `Main.java`, recompile, and rerun.

## thoth-resttemplate-02-proxy

This project researches configuration of a proxy for `RestTemplate`. The
following are used to configure the proxy:

```java
@Value("${my.proxy.host}") String proxyHost
@Value("${my.proxy.port}") Integer proxyPort
```

These are read from the `src/main/resources/application.properties` file.


## thoth-resttemplate-03-header_cookie_param

This project researches how to set HTTP header values, a cookie, and 
request parameters for `RestTemplate`. I used a personal account I have on an
external website to do this test because it allows me to easily verify
header, cookie, and request parameters are working. Consequently, most of
the configuration needed for this test is kept private.


