var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
mapOption = { 
    center: new kakao.maps.LatLng(37.537187, 127.005476),
    level: 3 // 지도의 확대 레벨
};

var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

var startSrc = 'https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/red_b.png', // 출발 마커이미지의 주소입니다	
    startSize = new kakao.maps.Size(50, 45), // 출발 마커이미지의 크기입니다 
    startOption = { 
        offset: new kakao.maps.Point(15, 43) // 출발 마커이미지에서 마커의 좌표에 일치시킬 좌표를 설정합니다 (기본값은 이미지의 가운데 아래입니다)
    };

// 출발 마커 이미지를 생성합니다
var startImage = new kakao.maps.MarkerImage(startSrc, startSize, startOption);

// 출발 마커가 표시될 위치입니다 
//var startPosition = new kakao.maps.LatLng(35.84378838918757, 128.5596652780815); 
var startgeocoder = new kakao.maps.services.Geocoder();
var start = document.getElementById('start').innerHTML;
//서울특별시 강남구 테헤란로 146

startgeocoder.addressSearch(start, function(result, status) {
//정상적으로 검색이 완료됐으면 
if (status === kakao.maps.services.Status.OK) {

   var startPosition = new kakao.maps.LatLng(result[0].y, result[0].x);

   // 결과값으로 받은 위치를 마커로 표시합니다
   var startMarker = new kakao.maps.Marker({
       map: map,
       position:startPosition,
       image:startImage
});
   map.setCenter(startPosition);
}
});
// 출발 마커를 생성합니다
//var startMarker = new kakao.maps.Marker({
//    map: map, // 출발 마커가 지도 위에 표시되도록 설정합니다
//    position: startPosition,
//    image: startImage // 출발 마커이미지를 설정합니다
//});

var arriveSrc = 'https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/blue_b.png', // 도착 마커이미지 주소입니다	
	arriveSize = new kakao.maps.Size(50, 45), // 도착 마커이미지의 크기입니다 
	arriveOption = { 
    	offset: new kakao.maps.Point(15, 43) // 도착 마커이미지에서 마커의 좌표에 일치시킬 좌표를 설정합니다 (기본값은 이미지의 가운데 아래입니다)
};

// 도착 마커 이미지를 생성합니다
var arriveImage = new kakao.maps.MarkerImage(arriveSrc, arriveSize, arriveOption);

var arrivegeocoder = new kakao.maps.services.Geocoder();
var end = document.getElementById('end').innerHTML;

arrivegeocoder.addressSearch(end, function(result, status) {
//정상적으로 검색이 완료됐으면 
if (status === kakao.maps.services.Status.OK) {

   var arrivePosition = new kakao.maps.LatLng(result[0].y, result[0].x);

   // 결과값으로 받은 위치를 마커로 표시합니다
   var arriveMarker = new kakao.maps.Marker({
       map: map,
       position:arrivePosition,
       image:arriveImage
});
}
});

// 도착 마커가 표시될 위치입니다 
//var arrivePosition = new kakao.maps.LatLng(35.84388022068777, 128.55988013274);	

// 도착 마커를 생성합니다 
//var arriveMarker = new kakao.maps.Marker({  
//    map: map, // 도착 마커가 지도 위에 표시되도록 설정합니다
//    position: arrivePosition,
//    image: arriveImage // 도착 마커이미지를 설정합니다
//});