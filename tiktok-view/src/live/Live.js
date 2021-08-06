import React from 'react';
import flvJs from 'flv.js';

export default class Live extends React.Component{

    initFlv = ($video) => {
        if ($video) {
            if (flvJs.isSupported()) {
                let flvPlayer = flvJs.createPlayer({
                    type: this.props.type,
                    url: this.props.url,
                });
                flvPlayer.attachMediaElement($video);
                flvPlayer.load();
                flvPlayer.play();
                this.flvPlayer = flvPlayer;
            }
        }
    }


    componentWillUnmount() {
        if (this.flvPlayer) {
            this.flvPlayer.unload();
            this.flvPlayer.detachMediaElement();
        }
    }

    render() {
        const { className, style } = this.props;
        return (
            <video
                className={className}
                controls={true}
                style={Object.assign({
                    width: '100%',
                }, style)}
                ref={this.initFlv}
            />
        )
    }
}
