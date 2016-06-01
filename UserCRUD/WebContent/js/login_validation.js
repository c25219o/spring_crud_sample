/**
 *
 */
const empty = '';
const idRequired = 'ユーザIDを入力してください';
const passRequired = 'パスワードを入力してください';



$(function() {
  $("#userId").focus(function() {
//    $(this).removeClass('invalid');
    $("#idError").text(empty);
//    $("#loginError").text(empty);
  });
  $("#userId").blur(function() {
    if ($(this).val() == empty) {
//      $(this).addClass('invalid');
//      $("#idError").text(idRequired);
    } else {
//      $(this).removeClass('invalid');
      $("#idError").text(empty);
    }
  });
});

$(function() {
  $("#password").focus(function() {
//    $(this).removeClass('invalid');
    $("#passError").text(empty);
//    $("#loginError").text(empty);
  });
  $("#password").blur(function() {
    if ($(this).val() == empty) {
//      $(this).addClass('invalid');
//      $("#passError").text(passRequired);
    } else {
//      $(this).removeClass('invalid');
      $("#passError").text(empty);
    }
  });
});

function isValid() {
  var result = true;
  console.log("validation");

  $("#loginError").text(empty);

  if ($("#userId").val() == empty) {
    $(this).addClass('invalid');
    $("#idError").text(idRequired);
    result = false;
  }

  if ($("#password").val() == empty) {
    $(this).addClass('invalid');
    $("#passError").text(passRequired);
    result = false;
  }
  return result;
}
