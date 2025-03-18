// ゲーム一覧→ゲーム削除画面遷移時

document.addEventListener('DOMContentLoaded', function () {
    let urlParams = new URLSearchParams(window.location.search);

    let gameId = urlParams.get('gameId') || '';
    let gameDate = urlParams.get('gameDate') || '';
    let gameTime = urlParams.get('gameTime') || '';
    let homeTeam = urlParams.get('homeTeam') || '';
    let awayTeam = urlParams.get('awayTeam') || '';
    let stadiumName = urlParams.get('stadiumName') || '';

    document.getElementById('displayId').textContent = gameId;
    document.getElementById('hiddenId').value = gameId;
    document.getElementById('displayDate').textContent = gameDate;
    document.getElementById('displayTime').textContent = gameTime;
    document.getElementById('displayHomeTeam').textContent = homeTeam;
    document.getElementById('displayAwayTeam').textContent = awayTeam;
    document.getElementById('displayStadiumName').textContent = stadiumName;

    // Log each value to the console
    console.log('Game ID:', gameId);
    console.log('Game Date:', gameDate);
    console.log('Game Time:', gameTime);
    console.log('Home Team:', homeTeam);
    console.log('Away Team:', awayTeam);
    console.log('Stadium Name:', stadiumName);
});

