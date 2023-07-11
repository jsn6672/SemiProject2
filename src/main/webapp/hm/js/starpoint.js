$(document).ready(function(){
  $('.star').mouseover(function(){
    // 사용자가 마우스를 가져다 댄 별점
    var rating = $(this).data('value');

    // 별 색칠하기
    $('.star').each(function(){
      if($(this).data('value') <= rating){
        $(this).text('★');
      }else{
        $(this).text('☆');
      }
    });
  });

  $('.star').click(function(){
    // 사용자가 선택한 별점
    var rating = $(this).data('value');

    // 별점을 숨겨진 입력 필드에 저장
    $('#starpoint').val(rating);
  });

  // 별점 UI에서 마우스를 떼면 별을 초기화하지만, 사용자가 선택한 별점은 유지
  $('.rating').mouseleave(function(){
    var rating = $('#starpoint').val();

    $('.star').each(function(){
      if($(this).data('value') <= rating){
        $(this).text('★');
      }else{
        $(this).text('☆');
      }
    });
  });
});