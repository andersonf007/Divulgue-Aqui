display.setDefault("background", 0.3, 0.6, 1)
display.setStatusBar( display.HiddenStatusBar )-- ocultar o status bar

-- O objeto principal que a API Storyboard é manipular um objeto "cena".
-- https://coronalabs.com/blog/2012/03/27/storyboard-scene-events-explained/
--https://docs.coronalabs.com/guide/system/composer/index.html
local composer = require ("composer")
--composer.gotoScene("CadastrarUsuario")
composer.gotoScene("Login")
--composer.gotoScene("Perfil")
--composer.gotoScene("Logado")
--composer.gotoScene("Publicacao")