# ByPass 安全旁路系统
***

>  ByPass 旁路系统是为防止刷单设立的黑名单系统


## 接口
***
### 1. 检查手机号是否在黑名单中
	
	
 > http://ip:port/check 

```
 Http Method `POST`
```
参数说明：
 
  + `phone` (必选项) : 要检查是否在黑名单的手机号
  
返回值说明：
  
  + 如果 phone参数为空时

```
   {
     "errmsg": “参数phone不为空.",
    "success": false,
    "errcode": "-1"
   }
``` 
  + 如果被检查的手机号在黑名单内

```
	{
	    "check": "T"
	}
```

  + 如果被检查的手机号不在黑名单内

```
	{
	    "check": "F"
	}
```
    
    
### 2. 检查黑白名单开启状态

***

> http://ip:port/isclose
> HTTP方法： POST

+ 

