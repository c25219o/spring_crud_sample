/**
 *
 */
const
empty = "";

function isValid() {
  var result = true;
  console.log("validation");

  if ($("#current").val() == empty) {
    $(this).addClass("invalidForm");
    $("#currentError").text("現在のパスワードを入力してください");
    result = false;
  } else {
    $(this).removeClass("invalidForm");
    $("#currentError").text(empty);
  }

  if ($("#newPass").val() == empty) {
    $(this).addClass("invalidForm");
    $("#newPassError").text("新しいパスワードを入力してください");
    result = false;
  } else {
    $(this).removeClass("invalidForm");
    $("#newPassError").text(empty);
  }

  if ($("#newConf").val() == empty) {
    $(this).addClass("invalidForm");
    $("#newConfError").text("新しいパスワード(確認用)を入力してください");
    result = false;
  } else {
    $(this).removeClass("invalidForm");
    $("#newConfError").text(empty);

    if ($("#newPass").val() != $("#newConf").val()) {
      $("#newConfError").text("新しいパスワードと確認用パスワードが一致しません");
      result = false;
    } else {
      $(this).removeClass("invalidForm");
      $("#newConfError").text(empty);
    }

  }

  return result;
}

/*
 * const empty = ''; $(function() {
 *
 * $('#name').blur(function() { if ($(this).val() == null || $(this).val() ==
 * empty) { $(this).addClass('invalid'); $('#alert_name').text('名前を入力してください'); }
 * else { $(this).removeClass('invalid'); $('#alert_name').text(empty); } });
 * });
 *
 * $(function() {
 *
 * $('input[type=text]').focus(function() { $(this).addClass('focus');
 * }).blur(function(){ $(this).removeClass('focus'); }); });
 *
 * $(function() {
 *
 * $('#message').blur(function() { if($(this).val().length > 10) {
 * $(this).addClass('invalid'); $('#alert_message').text('メッセージは10文字以内にしてください'); }
 * else { $(this).removeClass('invalid'); $('#alert_message').text(empty); } })
 * });
 */