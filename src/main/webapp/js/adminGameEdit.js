// ゲーム一覧→ゲーム編集画面遷移時

document.addEventListener('DOMContentLoaded', function () {
    let urlParams = new URLSearchParams(window.location.search);

    document.getElementById('displayId').textContent = urlParams.get('editGameId') || '';
    document.getElementById('hiddenId').value = urlParams.get('editGameId') || '';

    document.getElementById('gameDay').value = urlParams.get('editGameDate') || '';

    let gameTime = urlParams.get('editGameTime') || '';
    document.getElementById('gameTime').value = gameTime;
});
