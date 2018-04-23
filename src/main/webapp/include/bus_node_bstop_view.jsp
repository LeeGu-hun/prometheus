<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
    .wrap {position: absolute;left: 0;bottom: 40px;width: 362px;height: 312px;margin-left: -180px;text-align: left; overflow: hidden;font-size: 12px;font-family: 'Malgun Gothic', dotum, '돋움', sans-serif;line-height: 1.5;}
    .wrap * {padding: 0;margin: 0;}
    .wrap .info {width: 362px;height: 300px;border-radius: 5px;border-bottom: 2px solid #ccc;border-right: 1px solid #ccc;overflow: hidden;background: #fff;}
    .wrap .info:nth-child(1) {border: 0;box-shadow: 0px 1px 2px #888;}
    .info .title {padding: 5px 0 0 10px;height: 30px;background: #eee;border-bottom: 1px solid #ddd;font-size: 18px;font-weight: bold;}
    .info .close {position: absolute;top: 10px;right: 10px;color: #888;width: 17px;height: 17px;background: url('http://t1.daumcdn.net/localimg/localimages/07/mapapidoc/overlay_close.png');}
    .info .close:hover {cursor: pointer;}
    .info .body {position: relative;overflow: hidden;}
    .info .desc {width:362px; height: 250px; overflow: auto;}
    .desc .ellipsis {overflow: hidden; text-overflow: ellipsis; white-space: nowrap; font-size: 13px; font-weight: bold;}
    .desc .jibun {font-size: 12px; color: #444;margin-top: -2px; font-weight: normal;}
    .busImgs {width: 35%;  float: right; height:50px;}
    .info:after { content: '';position: absolute;margin-left: -12px;left: 50%;bottom: 0;width: 22px;height: 12px;background: url('http://t1.daumcdn.net/localimg/localimages/07/mapapidoc/vertex_white.png')}
    .info .link {color: #5085BB;}
    .mapBusTable {border-bottom: 2px dotted gray; width:99%; height:52px; margin-top: 5px; margin-bottom: 7px; padding-bottom: 5px;}
    .busNumGps { width: 60%; height:50px; float: left;}
    .crowdedImg {max-height: 30px; width:auto; margin: 0;}
    .busimg {width:38px; max-height: 45px;  margin-left : 10px; margin-right: 5px; float: left;}
    .busNum {font-weight:bold;}
</style>
${bSIResult}
