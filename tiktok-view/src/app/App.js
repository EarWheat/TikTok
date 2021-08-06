import React from 'react';
import { Menu, Layout } from 'antd';
import Game from "../game/Game";
import Live from "../live/Live";

const { Header, Content } = Layout;

export default class App extends React.Component {
    state = {
        current: 'live',
    };

    handleClick = e => {
        console.log('click ', e);
        this.setState({ current: e.key });
    };

    render() {
        const { current } = this.state;
        return (
            <Layout>
                <Header style={{ position: 'fixed', zIndex: 1, width: '100%' }}>
                    <Menu onClick={this.handleClick} selectedKeys="game" mode="horizontal">
                        <Menu.Item key="game">Game</Menu.Item>
                        <Menu.Item key="live" >live</Menu.Item>
                    </Menu>
                </Header>
                <Content className="site-layout" style={{ padding: '0 50px', marginTop: 64 }}>
                    {current === "game" ? <Game /> : <Live type={"flv"} url={"http://127.0.0.1/flv?port=1935&app=live&stream=test"}/>}
                </Content>
            </Layout>
        );
    }
}