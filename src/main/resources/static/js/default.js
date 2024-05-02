/* 기본 레이아웃 관련 자바스크립트 파일 */
$(function () {
    //***카테고리 관련 마우스오버 이벤트***
    //카테고리 a 마우스 오버시 디폴트 카테고리 - 여성
    $('.category__button').mouseover(function () {
        $('.category__div-women').css('display', 'block');
        $('.defalut-arrow').css('display', 'inline-block');
    });

    //남성, 여성 a 마우스오버시 해당 카테고리 div 노출
    $('a[class^="category__a-gender"]').hover(function () { //마우스오버시
        let classNm = $(this).attr('class');
        $('.' + classNm + '+div').css('display', 'block');

        //여성 a 옆 화살표 출력 여부
        (classNm === 'category__a-gender--women') ? $('.defalut-arrow').css('display', 'inline-block') : $('.defalut-arrow').css('display', 'none');
    }, function () { //마우스아웃시
        let classNm = $(this).attr('class');
        $('.' + classNm + '+div').css('display', 'none');
    });

    //남성, 여성 카테고리 div 마우스오버시 자기 자신 노출
    $('div[class^="category__div"]').hover(function () { //마우스오버시
        let classNm = $(this).attr('class');
        $('.' + classNm).css('display', 'block');
    }, function () { //마우스아웃시
        let classNm = $(this).attr('class');
        $('.' + classNm).css('display', 'none');
    });

})