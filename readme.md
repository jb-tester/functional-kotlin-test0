
1. the prefixes are ignored for some endpoints:
    see DeviceRouter3.kt
2. the endpoints set in cycles are not recognized:
    see SpecialCasesRouter4.kt
3. the generated HTTP requests don't detect port
4. the generated HTTP requests don't use correct HTTP methods:
    see GetPostSimpleRouter.kt, DeviceRouter3.kt
5. the generated HTTP request doesn't consider the endpoint prefixes that are correctly detected:
      UserRouter2.kt, DeviceRouter3.kt
6. the URLs passed via variables, constants and functions are not treated correctly:
   see SpecialCasesRouter4.kt