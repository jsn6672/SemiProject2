function signUpCheck() {
  let name = document.getElementById("name").value;
  let id = document.getElementById("id").value;
  let pw = document.getElementById("pw").value;
  let pwCheck = document.getElementById("pwCheck").value;
  let answer = document.getElementById("answer").value;
  let userBirth = document.querySelector("input[name='userBirth']");
  let userId = document.querySelector("input[name='userId']");
  let userPw = document.querySelector("input[name='userPw']");
  let userAnswer = document.querySelector("input[name='userAnswer']");
  let signup_btn = document.getElementById("signup_btn");

  // ID 확인
  if (containKR(userId) || id === "") {
    if (id === "") {
      document.getElementById("idError").innerHTML = "ID를 입력해주세요.";
    } else {
      document.getElementById("idError").innerHTML = "영어(대/소문자)와 숫자만 입력해주세요.";
    }
    userId.focus();
    return false;
  } else {
    document.getElementById("idError").innerHTML = "";
  }

  if (lessThan(userId, 5)) {
    document.getElementById("idError").innerHTML = "5글자 이상 입력해주세요.";
    userId.focus();
    return false;
  } else {
    document.getElementById("idError").innerHTML = "";
  }

  // 비밀번호 확인
  if (containPw(userPw) || pw === "") {
    if (pw === "") {
      document.getElementById("pwError").innerHTML = "비밀번호를 입력해주세요.";
    } else {
      document.getElementById("pwError").innerHTML = "영/숫자/특문 포함 8글자 이상";
    }
    userPw.focus();
    return false;
  } else {
    document.getElementById("pwError").innerHTML = "";
  }

  if (pw !== pwCheck) {
    document.getElementById("pwError").innerHTML = "";
    document.getElementById("pwCheckError").innerHTML = "비밀번호가 일치하지 않습니다.";
    return false;
  } else {
    document.getElementById("pwError").innerHTML = "";
    document.getElementById("pwCheckError").innerHTML = "";
  }

  if (pwCheck === "") {
    document.getElementById("pwCheckError").innerHTML = "비밀번호를 다시 입력해주세요.";
    return false;
  } else {
    document.getElementById("pwCheckError").innerHTML = "";
  }
  // 이름 확인
  if (name === "") {
    document.getElementById("nameError").innerHTML = "이름을 입력해주세요.";
    return false;
  } else {
    document.getElementById("nameError").innerHTML = "";
  }

  // 생일답변 길이
  if (lessThan(userBirth, 6)) {
    document.getElementById("birthError").innerHTML = "숫자로만 입력해주세요.";
    userBirth.focus();
    return false;
  } else {
    document.getElementById("birthError").innerHTML = "";
  }
  // 질문에 대한 답변
  if (answer === "") {
    document.getElementById("answerError").innerHTML = "질문에 답해주세요.";
    userAnswer.focus();
    return false;
  } else {
    document.getElementById("answerError").innerHTML = "";
  }

  // 모든 유효성 검사 통과
  document.getElementById("idError").innerHTML = "";
  document.getElementById("nameError").innerHTML = "";
  document.getElementById("pwError").innerHTML = "";
  document.getElementById("pwCheckError").innerHTML = "";
  document.getElementById("birthError").innerHTML = "";
  document.getElementById("answerError").innerHTML = "";

  idCheck();
}

function idCheck() {
  let id = document.getElementById("id").value;
  $.ajax({
    type: "GET",
    url: "SignUpC",
    data: { id: id },
    success: function (response) {
      if (response == 0) {
        document.getElementById("idCheckResult").innerHTML = "사용 가능한 아이디입니다.";
        idCheckResult.style.color = "green";
      } else if (response == 1) {
        document.getElementById("idCheckResult").innerHTML = "이미 사용 중인 아이디입니다.";
        idCheckResult.style.color = "red";
      } else {
        document.getElementById("idCheckResult").innerHTML = "서버 요청 실패";
      }
    },
    error: function () {
      document.getElementById("idCheckResult").innerHTML = "서버 요청 실패";
    },
  });
}

function signUpSubmit() {
  if (signUpCheck()) {
    let msg = "회원가입이 완료되었습니다.";
    alert(msg);
    return true;
  }
}

document.getElementById("signup_btn").addEventListener("click", signUpSubmit);