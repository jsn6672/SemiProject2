$(function() {
  $(".lang-btn").click(function() {
    var lang = $(this).data("lang");
    var apiEndpoint = "http://api.visitjeju.net/vsjApi/contents/searchList";
    var apiKey = "kzqn5gj47jco7e38";
    var category = "c1";

    if (lang === "ko") {
      apiEndpoint += "?apiKey=" + apiKey + "&locale=kr&category=" + category;
    } else if (lang === "ja") {
      apiEndpoint += "?apiKey=" + apiKey + "&locale=jp&category=" + category;
    }

    $.ajax({
      url: apiEndpoint,
      type: "GET",
      success: function(data) {
        // API로부터 받아온 데이터를 처리하는 로직 작성
        console.log(data);
      },
      error: function(xhr, status, error) {
        // API 요청에 실패한 경우의 처리 로직 작성
        console.log(error);
      }
    });
  });
});
