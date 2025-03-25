// 一覧画面→試合情報追加

document.addEventListener('DOMContentLoaded', function() {
  // 前のページから送信された情報を取得
  const params = new URLSearchParams(window.location.search);
  const gameDay = params.get('gameDay');
  const gameTime = params.get('gameTime');
  const homeTeam = params.get('homeTeam');
  const awayTeam = params.get('awayTeam');
  const stadium = params.get('stadium');

  // 確認画面に情報を表示
  document.getElementById('displayDay').textContent = gameDay;
  document.getElementById('displayTime').textContent = gameTime;
  document.getElementById('displayHomeTeam').textContent = homeTeam;
  document.getElementById('displayAwayTeam').textContent = awayTeam;
  document.getElementById('displayStadium').textContent = stadium;

  // hiddenフィールドに情報を設定
  document.getElementById('hiddenDay').value = gameDay;
  document.getElementById('hiddenTime').value = gameTime;
  document.getElementById('hiddenHomeTeam').value = homeTeam;
  document.getElementById('hiddenAwayTeam').value = awayTeam;
  document.getElementById('hiddenStadium').value = stadium;
});
