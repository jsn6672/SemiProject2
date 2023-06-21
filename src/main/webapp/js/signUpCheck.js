
function signUpCheck() {
  var name = document.getElementById("name").value;
  var id = document.getElementById("id").value;
  var pw = document.getElementById("pw").value;
  var pwCheck = document.getElementById("pwCheck").value;
  var check = true;

	let id3 =  document.querySelector("input[name='id3']");
  // 이름 확인
  if (name === "") {
    document.getElementById("nameError").innerHTML = "이름을 입력해주세요.";
    check = false;
  } else {
	
    document.getElementById("nameError").innerHTML = "";
  }

  // ID 확인
  
  
 
  if (containKR(id3) || id === "") {
    
  if (id === "") {
    document.getElementById("idError").innerHTML = "ID를 입력해주세요.";
	}else{
    document.getElementById("idError").innerHTML = "ID는 영어만 입력 가능합니다.";
		
	}
    id3.focus(); 
    check = false;
  } else {
    document.getElementById("idError").innerHTML = "";
  }


  // 비밀번호 확인
  if (pw !== pwCheck) {
    document.getElementById("pwError").innerHTML = "";
    document.getElementById("pwCheckError").innerHTML = "비밀번호가 동일하지 않습니다.";
    check = false;
    return false;
  } else {
    document.getElementById("pwError").innerHTML = "";
    document.getElementById("pwCheckError").innerHTML = "";
  }

  if (pw === "") {
    document.getElementById("pwError").innerHTML = "비밀번호를 입력해주세요.";
    check = false;
  } else {
    document.getElementById("pwError").innerHTML = "";
  }

  if (pwCheck === "") {
    document.getElementById("pwCheckError").innerHTML = "비밀번호를 다시 입력해주세요.";
    check = false;
  } else {
    document.getElementById("pwCheckError").innerHTML = "";
  }

  if (check) {
    document.getElementById("idError").innerHTML = "";
    document.getElementById("nameError").innerHTML = "";
    document.getElementById("pwError").innerHTML = "";
    document.getElementById("pwCheckError").innerHTML = "";
  }else{
	return false;
}
  
  
}
function containKR(input){
	let ok = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM_@.1234567890";
	console.log(111)
	for(let i = 0; i < input.value.length; i++){
		if(ok.indexOf(input.value[i]) == -1){	
			return true;
		}	
	}	
}
   