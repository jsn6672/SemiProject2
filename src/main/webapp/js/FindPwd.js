function FindPwdCheck() {
    let id = document.getElementById("find_pwd_id").value;
    let answer = document.getElementById("userAnswer").value;
    let newPwd = document.getElementById("newPwd").value;
    let pwCheck = document.getElementById("newPwdCheck").value;
    let Confirm_btn = document.getElementById("Confirm_btn");

    let idError = document.getElementById("idError");
    let answerError = document.getElementById("answerError");
    let pwError = document.getElementById("pwError");
    let pwCheckError = document.getElementById("pwCheckError");

    // 유효성 검사 및 오류 초기화
    idError.innerHTML = "";
    answerError.innerHTML = "";
    pwError.innerHTML = "";
    pwCheckError.innerHTML = "";


    // ID 확인
    if (containKR(id) || id === "") {
        if (id === "") {
            idError.innerHTML = "ID를 입력해주세요.";
        } else {
            idError.innerHTML = "영어(대/소문자)와 숫자만 입력해주세요.";
        }
        return false;
    }

    if (lessThan(id, 5)) {
        idError.innerHTML = "5글자 이상 입력해주세요.";
         return false;
    }

    // 질문에 대한 답변
    if (answer === "") {
        answerError.innerHTML = "질문에 답해주세요.";
         return false;
    }
    if (answer !== "")

    // 비밀번호 확인
    if (containPw(newPwd) || newPwd === "") {
        if (newPwd === "") {
            pwError.innerHTML = "비밀번호를 입력해주세요.";
        } else {
            pwError.innerHTML = "영/숫자/특문 포함 8글자 이상";
        }
          return false;
    }

    if (newPwd !== pwCheck) {
        pwCheckError.innerHTML = "비밀번호가 일치하지 않습니다.";
        return false;
    }

    if (pwCheck === "") {
        pwCheckError.innerHTML = "비밀번호를 다시 입력해주세요.";
        return false;
    }

    // 모든 유효성 검사 통과
    if (isValid) {
        idError.innerHTML = "";
        answerError.innerHTML = "";
        pwError.innerHTML = "";
        pwCheckError.innerHTML = "";
    }
}

function containKR(input) {
    let ok = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM1234567890";
    for (var i = 0; i < input.length; i++) {
        if (ok.indexOf(input[i]) === -1) {
            return true;
        }
    }
    return false;
}

function containPw(input) {
    let pwContain = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{8,}$/;
    return !pwContain.test(input);
}

function lessThan(input, length) {
    return input.length < length;
}

/*function msgbox() {
    var msg = '비밀번호 변경이 완료 되었습니다.';
    if (msg) {
        alert(msg);
        return true;
    }
}
*/
// 팝업 열기
function openChangePopup() {
   let Changepopup = document.getElementById("pwd_Changer_Popup");
   let dim2 = document.getElementById("dim2");
   Changepopup.style.display = "block";
   dim2.style.display = "block";
}

// 팝업 닫기
function closeChangePopup() {
   let ChangePopup = document.getElementById("pwd_Changer_Popup");
   let dim2 = document.getElementById("dim2");
   ChangePopup.style.display = "none";
   dim2.style.display = "none";
}

function ChangePopup() {
   let findPwdBtn = document.getElementById("findPwd_btn");
   let dim2 = document.getElementById("dim2");

   findPwdBtn.addEventListener("click", openChangePopup);
   dim2.addEventListener("click", closeChangePopup);
   // dim 클릭 시 팝업 닫기
   // 로그인 버튼 클릭 시 팝업 열기
   
}
window.addEventListener("load", ChangePopup);


