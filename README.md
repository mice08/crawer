# Crawer 爬虫系统
***

>  Crawer 爬虫系统是为爬取同行网站数据的系统


## /cache/sync接口
***
### 1. 
	
	
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

*** 
## ／citylist接口
*** 
### 1. 

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
 

*** 
## HotelDetailController接口
*** 
### 1. 

> http://ip:port/hoteldetail

```
 Http Method `POST`
```

参数说明：
 
  + `hotelId` (必选项) : 
  + `fileUrl` (必选项) : 
  
返回值说明：
  
  + 执行成功

```
   {
   }
``` 


*** 
### 2. 

> http://ip:port/hoteldetail2

```
 Http Method `POST`
```

参数说明：
 
  + `hotelId` (必选项) : 
  
返回值说明：
  
  + 执行成功

```
   {
   }
``` 



*** 
## HotelImageController接口
*** 
### 1. 测试接口，爬取单个酒店

> http://ip:port/hotel-image/insert

```
 Http Method `POST`
```

参数说明：
   
返回值说明：
  
  + 执行成功

```
   {
	"result": "success",
	"success": true
   }
``` 



*** 
## HotelPriceJobController接口
*** 
### 1. 

> http://ip:port/hotel-price-job/add-city-hotel

```
 Http Method `POST`
```

参数说明：
 
  + `city` (必选项) : 
  
返回值说明：
  
  + 执行成功

```
   {
	"result": "city 的 hotelList.size() 家酒店添加到价格刷新队列",
	"success": true
   }
``` 

  + 执行失败

```
   {
	"result": "e.toString()",
	"success": false
   }
``` 

*** 
### 2. 

> http://ip:port/hotel-price-job/add-all-hotel

```
 Http Method `POST`
```

参数说明：
 
  
返回值说明：
  
  + 执行成功

```
   {
	"result": "city 的 hotelList.size() 家酒店添加到价格刷新队列",
	"success": true
   }
``` 

  + 执行失败

```
   {
	"result": "e.toString()",
	"success": false
   }
``` 


*** 
### 3. 立即爬取 指定酒店

> http://ip:port/hotel-price-job/add-hotel-to-first

```
 Http Method `POST`
```

参数说明：
 
  + `hotelId` (必选项) : 指定酒店的id
  
返回值说明：
  
  + 执行成功

```
   {
	"message": {hotelId:,cityName:},
	"success": true
   }
``` 

  + 当hotelId 为空

```
   {
	"message": "",
	"success": false
   }
``` 

  + 当hotel未查询到

```
   {
	"message": "",
	"success": false
   }
``` 

*** 
## HotelScoreController接口
*** 
### 1. 

> http://ip:port/comments/updatescore

```
 Http Method `POST`
```

参数说明：
 
  + `hotelId` (必选项) : 
  + `score` (必选项) : 
  
返回值说明：
  
  + 执行成功

```
   {
	"score": score,
	"success": true
   }
``` 

  + 执行失败

```
   {
	"errorMessage": "failed to subjectMapper.updateByHotelId by hotelId:%s; score:%s",
	"success": false
   }
``` 

*** 
### 2. 

> http://ip:port/comments/loadhotelids

```
 Http Method `POST`
```

参数说明：
 
  + `type` (必选项) : 
  + `target` (必选项) : 
  
返回值说明：
  
  + 执行成功

```
   {
	"success": true
   }
``` 


*** 
### 3. 

> http://ip:port/comments/loadscore

```
 Http Method `POST`
```

参数说明：
 
  + `maxHotels` (必选项) : 
  + `hotelId` (必选项) : 
  
返回值说明：
  
  + 执行成功

```
   {
	"success": true
   }
``` 


*** 
## MtHotelDetailController接口
*** 
### 1. 

> http://ip:port/mthoteldetail

```
 Http Method `POST`
```

参数说明：
 
  
返回值说明：
  
  + 执行成功

```
   {
	"beijin": 123,
	"beijin": 123
   }
``` 



*** 
## OtaPriceController接口
*** 
### 1. 

> http://ip:port/getOtaPrice

```
 Http Method `POST`
```

参数说明：
 
  + `otsHotelId` (必选项) : 
  + `otsHotelName` (必选项) :
  + `exHotelId` (必选项) :
  + `otsRoomTypeId` (必选项) :
  + `exRoomTypeId` (必选项) :
  + `roomTypeId` (必选项) :
  + `roomTypeKey` (必选项) :
  + `hotelId` (必选项) :
  + `hotelSourceId` (必选项) :
  + `price` (必选项) :
  + `oprice` (必选项) :
  + `realPrice` (必选项) :
  + `originPrice` (必选项) :
  + `showPrice` (必选项) :
  + `otaShowPrice` (必选项) :
  + `wrapperName` (必选项) :
  + `wrapperId` (必选项) :
  + `allRoomCount` (必选项) :
  + `availableRoomcount` (必选项) :
  + `valid` (必选项) :
  + `createTime` (必选项) :
  + `site` (必选项) :
  
返回值说明：
  
  + 执行成功

```
   {
	"SUCCESS": true,
	"info": [{
			"otsHotelId":
			"otsHotelName"
			"exHotelId":
			"otsRoomTypeId":
			"exRoomTypeId":
			"roomTypeId":
			"roomTypeKey":
			"hotelId":
			"hotelSourceId":
			"price":
			"oprice":
			"realPrice":
			"originPrice":
			"showPrice":
			"otaShowPrice":
			"wrapperName":
			"wrapperId":
			"allRoomCount":
			"availableRoomcount":
			"valid":
			"createTime":
			"site":	
		},{
			"otsHotelId":
			"otsHotelName"
			"exHotelId":
			"otsRoomTypeId":
			"exRoomTypeId":
			"roomTypeId":
			"roomTypeKey":
			"hotelId":
			"hotelSourceId":
			"price":
			"oprice":
			"realPrice":
			"originPrice":
			"showPrice":
			"otaShowPrice":
			"wrapperName":
			"wrapperId":
			"allRoomCount":
			"availableRoomcount":
			"valid":
			"createTime":
			"site":	
		}]
   }
``` 


*** 
### 2. 

> http://ip:port/catheOtaPrice

```
 Http Method `POST`
```

参数说明：
 
  + `otsHotelId` (必选项) : 
  + `otsHotelName` (必选项) :
  + `exHotelId` (必选项) :
  + `otsRoomTypeId` (必选项) :
  + `exRoomTypeId` (必选项) :
  + `roomTypeId` (必选项) :
  + `roomTypeKey` (必选项) :
  + `hotelId` (必选项) :
  + `hotelSourceId` (必选项) :
  + `price` (必选项) :
  + `oprice` (必选项) :
  + `realPrice` (必选项) :
  + `originPrice` (必选项) :
  + `showPrice` (必选项) :
  + `otaShowPrice` (必选项) :
  + `wrapperName` (必选项) :
  + `wrapperId` (必选项) :
  + `allRoomCount` (必选项) :
  + `availableRoomcount` (必选项) :
  + `valid` (必选项) :
  + `createTime` (必选项) :
  + `site` (必选项) :
  
返回值说明：
  
  + 执行成功

```
   {
	"SUCCESS": true,
	"message":“完成”
   }
``` 


*** 
## QunarHotelMapSyncController接口
*** 
### 1. 

> http://ip:port/qunarhotelmapsync

```
 Http Method `GET`
```

参数说明：
 
  + 
  
返回值说明：
  
  + 执行成功

```
   {
	"SUCCESS": true,
   }
``` 

*** 
### 2. 

> http://ip:port/hotelsmapsync

```
 Http Method `POST`
```

参数说明：
 
  + 
  
返回值说明：
  
  + 执行成功

```
   {
	"SUCCESS": true,
   }
``` 

*** 
### 3. 

> http://ip:port/qunarhotelmapsyncex

```
 Http Method `GET`
```

参数说明：
 
  + 
  
返回值说明：
  
  + 执行成功

```
   {
	"SUCCESS": true,
   }
``` 

*** 
### 4. 

> http://ip:port/hotelsmapsyncex

```
 Http Method `POST`
```

参数说明：
 
  + 
  
返回值说明：
  
  + 执行成功

```
   {
	"SUCCESS": true,
   }
``` 


*** 
### 5. 

> http://ip:port/hoteltest

```
 Http Method `GET`
```

参数说明：
 
  + 
  
返回值说明：
  
  + 执行成功

```
   {
	"SUCCESS": true,
   }
``` 



*** 
## QunarHotelSyncController接口
*** 
### 1. 

> http://ip:port/qunarhotelsync

```
 Http Method `GET`
```

参数说明：
 
  + 
  
返回值说明：
  
  + 执行成功

```
   {
	"SUCCESS": true,
   }
``` 


*** 
### 2. 

> http://ip:port/hotelsync

```
 Http Method `GET`
```

参数说明：
 
  + 
  
返回值说明：
  
  + 执行成功

```
   {
	"SUCCESS": true,
   }
``` 


*** 
### 3. 

> http://ip:port/hotelimagesync

```
 Http Method `GET`
```

参数说明：
 
  + 
  
返回值说明：
  
  + 执行成功

```
   {
	"SUCCESS": true,
   }
``` 


*** 
### 4. 

> http://ip:port/hotelimagesynccity

```
 Http Method `POST`
```

参数说明：
 
  + 
  
返回值说明：
  
  + 执行成功

```
   {
	"SUCCESS": true,
   }
``` 

*** 
## ReFreshCityListController接口
*** 
### 1. 清空redis城市队列

> http://ip:port/citylist/removecitylist

```
 Http Method `POST`
```

参数说明：
 
  + 
  
返回值说明：
  
  + 执行成功

```
   {
	"SUCCESS": true,
	"result":"请求成功"
   }
``` 


*** 
### 2. 增量更新redis城市队列

> http://ip:port/citylist/refreshcitylist

>查询数据库中的城市，放至redis中的城市队列
```
 Http Method `POST`
```

参数说明：
 
  + 
  
返回值说明：
  
  + 执行成功

```
   {
	"SUCCESS": true,
	"result":"请求成功"
   }
``` 



*** 
### 3. 查询redis城市队列

> http://ip:port/citylist/listcity

```
 Http Method `POST`
```

参数说明：
 
  + 
  
返回值说明：
  
  + 执行成功

```
   {
	"SUCCESS": true,
	"citylist":[{
		"id":
		"cityCode":
		"cityName":
		"cityUrl":
		"createTime":
		"updateTime":
		"siteId":
		"cityType":
		},{
		"id":
		"cityCode":
		"cityName":
		"cityUrl":
		"createTime":
		"updateTime":
		"siteId":
		"cityType":
		}]
   }
``` 


*** 
### 4. 按redis城市队列，增量更新酒店队列

> http://ip:port/citylist/refreshhotel

>按redis城市队列，查询数据库中的酒店，放至redis中的酒店下轮队列

```
 Http Method `POST`
```

参数说明：
 
  + 
  
返回值说明：
  
  + 执行成功

```
   {
	"SUCCESS": true,
   }
``` 


*** 
### 5.  立即爬取 指定城市

> http://ip:port/citylist/addCityToFirst

```
 Http Method `POST`
```

参数说明：
 
  + `cityName` (必选项) : 指定爬取的城市
  
返回值说明：
  
  + 执行成功

```
   {
	"SUCCESS": true,
   }
``` 

  + 当城市为空

```
   {
	"SUCCESS": false,
	"message":"cityName is null"
   }
``` 



*** 
## 定时任务
*** 
### 1.  按redis城市队列，增量更新酒店队列
> 每天凌晨0点10分执行
