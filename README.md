# Thoth RestTemplate

Research on Spring `RestTemplate` calling a REST endpoint.

## thoth-resttemplate-00

This contains an `application-mike.properties` file which
is ignored by Git and not committed to GitHub since it
contains properties to remain private.

```txt
my.proxy.host=
my.proxy.port=
my.site.rest.url=url_that_ends_in_php
my.site.rest.cookie.name=cookie_name_that_ends_in_php
my.site.rest.cookie.value=cookie_value_is_long_string
my.site.rest.param.name=param_name_refs
my.site.rest.param.valueFormat=param_value_big_array
```

## thoth-resttemplate-01-it_works

Using `RestTemplate` to call a test REST endpoint that is publicly available
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
the configuration needed for this test is kept private.  The private
file is thoth-resttemplate-00 `application-mike.properties`, which is not 
committed to source control.

The `application-mike.properties` is activated when Spring Boot is run with 
the 'mike' profile. Right-click the `thoth-resttemplate-03-header_cookie_param`
project in NetBeans, select "Run Maven", select "Spring boot run (mike)"


