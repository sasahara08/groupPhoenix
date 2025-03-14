<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>チケット購入 選択</title>
    <link rel="stylesheet" href="game.css" />
    <link rel="stylesheet" href="html5reset-1.6.1.css" />
    <link rel="stylesheet" href="style.css" />
  </head>
  <body>
    <main>
      <h1>座席と枚数を選択する</h1>
      <div class="box2">
        <p>試合日</p>
        <p>開始時間</p>
        <p>対戦チーム</p>
        <p>試合場所</p>
      </div>

      <div class="box2">
        <label class="selectbox-3">
          <p>
            枚数を選択する
            <select name="tickets" form="example">
              <option value="1">1</option>
              <option value="2">2</option>
              <option value="3">3</option>
              <option value="4">4</option>
            </select>
          </p>
        </label>
      </div>

      <div class="box2">
        <label class="selectbox-3">
          <p>
            座席を選択する
            <select name="tickets" form="example">
              <option value="a">外野応援席</option>
              <option value="b">内野指定席(北側スタンド)</option>
              <option value="c">内野指定席(南側スタンド)</option>
            </select>
          </p>
        </label>
      </div>

      <div class="button99">
        <button type="button" onclick="location.href='gameLogin.html'">
          戻る
        </button>
        <button type="button" onclick="location.href='buyTicketConfirm.html'">
          確認する
        </button>
      </div>
    </main>
  </body>
</html>
