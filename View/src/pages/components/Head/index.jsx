import React, { PureComponent } from 'react';
import Head from './Head';
import { connect } from 'dva';


class Index extends PureComponent  {
    constructor(props) {
        super(props)
        this.state = {
            menuList: []
        }
    }

    componentWillMount(){
        // console.log(styles);
        // console.log(this.props);
        this.props.dispatch({type: "head/listQuerMenu"});
        this.setState({
            menuList: this.props.head.menuList
        })
        
    }

    render() {
        return (
            <Head menuList={this.state.menuList}/>
        )
    }
}

export default connect(({ head }) => ({ head }))(Index)