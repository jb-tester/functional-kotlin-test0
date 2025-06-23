
1. the prefixes are ignored for some endpoints:
     - see DeviceRouter3.kt
     - https://youtrack.jetbrains.com/issue/IDEA-374777/Spring-Webflux-incorrectly-detected-functional-route-endpoints-case
2. the endpoints set in cycles are not recognized:
     - see SpecialCasesRouter4.kt
     - https://youtrack.jetbrains.com/issue/IDEA-374768/Spring-Webflux-support-the-endpoints-in-the-functional-routes-with-cycles
3. the generated HTTP requests don't detect port
     - https://youtrack.jetbrains.com/issue/IDEA-374772/Spring-Webflux-HTTP-Requests-generating-for-functional-routes-detect-port
4. the generated HTTP requests don't use correct HTTP methods:
     - see GetPostSimpleRouter.kt, DeviceRouter3.kt
     - https://youtrack.jetbrains.com/issue/IDEA-374773/Spring-Webflux-correct-HTTP-method-should-be-used-for-functional-route-endpoints
5. the generated HTTP request doesn't consider the endpoint prefixes that are correctly detected:
     - see UserRouter2.kt, DeviceRouter3.kt
     - https://youtrack.jetbrains.com/issue/IDEA-374778/Spring-Webflux-more-cases-for-incorrect-HTTP-Request-generation-for-correcyly-recognized-endpoints
6. the URLs passed via variables, constants and functions are not treated correctly:
     - see SpecialCasesRouter4.kt