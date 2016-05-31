/**
 *
 */

function isValid() {
  let result = true;
  console.log("validation");

  if ($("#current").text().value() == "") {
    this.addClass("invalidForm");
    $("#currentError").text("現在のパスワードを入力してください");
    result = false;
  }

  if ($("#newPass").text().value() == "") {
    this.addClass("invalidForm");
    $("#newPassError").text("新しいパスワードを入力してください");
    result = false;
  }

  if ($("#newConf").text().value() == "") {
    this.addClass("invalidForm");
    $("#newConfError").text("新しいパスワード(確認用)を入力してください");
    result = false;
  }

  if ($("#newPass").text().value() != $("#newConf").text().value()) {
      $("#newConfError").text("新しいパスワードと確認用パスワードが一致しません");
      result = false;
  }

  return result;
}