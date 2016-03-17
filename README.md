# Crawer 爬虫系统
***

>  Crawer 爬虫系统是为爬取同行网站数据的系统


## /cache/sync接口
***
### 1. 检查手机号是否在黑名单中
	
	
 > http://ip:port/cache/sync 

```
 Http Method `POST`
```
参数说明：
 
  + `fromHostAndPort` (必选项) : 
  + `fromMasterName` (必选项) : 
  + `hostAndPort` (必选项) : 
  + `masterName` (必选项) : 
  
返回值说明：
  
  + 如果 执行成功

```
   {
	"errormessage": "failed to do cacheSyncService.sync...message:",
	"success": true
   }
``` 
  + 如果 执行失败

```
   {
	"errormessage": "xxxxx",
	"success": false
   }
``` 
    
   
## ／citylist接口
*** 
### 1. 检查黑白名单开启状态

***

> http://ip:port/citylist/add

```
 Http Method `POST`
```

参数说明：
 
  + `sitename` (必选项) : 
  
返回值说明：
  
  + 执行成功

```
   {
	"result": "请求成功",
	"success": true
   }
``` 
 





