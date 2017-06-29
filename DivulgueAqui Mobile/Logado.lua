local widget =  require ("widget")
local composer = require ("composer")
local web = require ("webServiceConnection")
local scene = composer.newScene()
--local logado = {}

local ButtonProfile
local ButtonPublicacao
local ButtonListar
local tableView
local tabelaDaPublicacao
local grupoCena
--// integracao continua / treves/ ap veiou e treves
--um ambiente de execucao 
--cria uma maquina virtual mas proxima do que vc precisa
--uma maquina praticamente igual a um ambiente de producao mais nao é um ambiente de producao
-- ambiente de omologacao
-- o cliente usa o amiente de producao e nao de omologacao
-- almetar a chance de nao dar erros no ambiente de producao

local function onRowRender( event )-- metodo para preencher o tableView
		--Set up the localized variables to be passed via the event table
		local row = event.row
		local id = row.index
		row.bg = display.newRect( 0, 0, display.contentWidth, 60 )
		row.bg.anchorX = 0
		row.bg.anchorY = 0
		row.bg:setFillColor( 1, 1, 1 )
		row:insert( row.bg )

		row.data = display.newText("data: ".. tabelaDaPublicacao[id].data, 12, 0, native.systemFontBold, 18 )
		row.data.anchorX = 0
		row.data.anchorY = 0.5
		row.data:setFillColor( 0 )
		row.data.y = 20
		row.data.x = 42

		row.categoria = display.newText("categoria: "..tabelaDaPublicacao[id].categoria, 12, 0, native.systemFont, 18 )
		row.categoria.anchorX = 0
		row.categoria.anchorY = 0.5
		row.categoria:setFillColor( 0.5 )
		row.categoria.y = 40
		row.categoria.x = 42

		row.localidade = display.newText("local: "..tabelaDaPublicacao[id].localidade, 12, 0, native.systemFont, 18 )
		row.localidade.anchorX = 0
		row.localidade.anchorY = 0.5
		row.localidade:setFillColor( 0.5 )
		row.localidade.y = 60
		row.localidade.x = 42

		local options = 
		{
		    text = tabelaDaPublicacao[id].descricao ,     
		    x = 12,
		    y = 0,
		    width = 250,
		    height = 40,
		    font = native.systemFont,   
		    fontSize = 18,
		    align = "left"  -- Alignment parameter
		}
		row.descricao = display.newText(options)
		row.descricao.anchorX = 0
		row.descricao.anchorY = 0.5
		row.descricao:setFillColor( 0.5 )
		row.descricao.y = 87
		row.descricao.x = 42

		row.status = display.newText("status: " ..tabelaDaPublicacao[id].status, 12, 0, native.systemFont, 18 )
		row.status.anchorX = 0
		row.status.anchorY = 0.5
		row.status:setFillColor( 0.5 )
		row.status.y = 115
		row.status.x = 42

		row:insert( row.data )
		    row:insert( row.categoria )
		    	row:insert( row.localidade )
		    		row:insert( row.descricao )
		    			row:insert( row.status )-- 
		return true 
end

function fazerLogout(event)
	print("unhum")
	if event.phase == "began" then
		print("entrou")
	end
end

function scene:create(event)

	 grupoCena = self.view 

	logout = display.newImage( "logout.png", display.contentWidth - 15, 15)
    grupoCena:insert( logout )

	ButtonProfile = widget.newButton( 
		{
		label="Perfil", 
		x = display.contentWidth/2 * 0.50, 
		y = display.contentHeight,-- / 1.05,--/2 * 2.10
		width = 150,
		height = 40, 
		shape = "roundedRect" , 
		fillColor = { default={1,1,0,1}, over={1,0.1,0.7,0.4}}, 
		onPress = visualizarPerfil 
		} 
	)
	grupoCena:insert(ButtonProfile)

	ButtonPublicacao = widget.newButton( 
		{
		label="Publicação", 
		x = display.contentWidth/2 * 1.50, 
		y = display.contentHeight,-- * 0.99, 
		width = 150,
		height = 40, 
		shape = "roundedRect", 
		fillColor = { default={1,1,0,1}, over={1,0.1,0.7,0.4}}, 
		onPress = realizarPublicacao}
	)

	grupoCena:insert( ButtonPublicacao)

	
    logout:addEventListener("touch",fazerLogout)

end



function  visualizarPerfil(event) -- toque no botao Perfil 
	-- vai para a pagina de perfil
	if event.phase == "began" then
		web:recoverUserIdWS(codigoUser)
		composer.gotoScene("Perfil")
	end
end

function realizarPublicacao(event)
	if event.phase == "began" then
		composer.gotoScene("Publicacao")
	end
end

function recebeTabelaDaPublicacao(tabela) -- metodo que recebe a tabela de publicacao e define o tamanho de cada campo do tableView
	
	tabelaDaPublicacao = tabela
	for dis,dat in ipairs(tabela) do
	 	--print(dis .. "-" .. dat.data)
	 	myList:insertRow{
		rowHeight = 125,
		isCategory = false,
		rowColor = { 1, 0.2, 0.1 },
		lineColor = { 1, 0.20, 0.70 }}
 	end
end

function scene:show(event)
	myList = widget.newTableView {
		top = 40, 
		width = display.contentWidth, 
		height = ButtonProfile.y - 70,---display.contentHeight * 0.80,
		HideBackground = true ,
		onRowRender = onRowRender,
		onRowTouch = onRowTouch,
		listener = scrollListener
	}
	grupoCena:insert( myList)
end

function scene:hide(event)
	print("hide")
	print(myList)
	if event.phase == "did" then
		print("entrou")
		display.remove(myList)
	end
	
end


function scene:destroy(event)
--	display.remove(myList)

end

scene:addEventListener( "create", scene ) -- adiciona o evento da funcao de criar 
scene:addEventListener( "show", scene ) -- adiciona o evento da funcao de entre 
scene:addEventListener( "hide", scene ) -- adiciona o evento da funcao de sair
scene:addEventListener( "destroy", scene )-- adiciona o evento da funcao de destruir 

return scene
