
import React, { Component } from 'react';
import {connect} from 'react-redux';
import {fetchTags, selectTag} from '../actions/tagActions'

class TagSelect extends Component {

    state = {
        tagId : null,
    }

    handleChange = (event) => {

        if (event.target.id === "TagSelect.tagSelect"){

            this.props.selectTag(event.target.value);

        }
    } 


    componentDidMount(){
    
        this.props.fetchTags();
    }

    render(){

        let options = [];

        if (this.props.tags){

            this.props.tags.forEach(tag => {

                options.push(<option key = {tag.id} value = {tag.name}>{tag.name}</option>);
                
            })

        }


        return (

            <div className="card text-white bg-primary mb-3" >

                <div className="card-body">

                    <select id = "TagSelect.tagSelect" onChange = {this.handleChange}
                        defaultValue = {this.props.item?this.props.tag.id:""} 
                        placeholder="Tag"
                        className = "form-control" >

                        <option value = {""} key = {0} >Please, Select a task...</option>
                        {
                            options
                        }
                    </select>
                </div>


            </div>


        );

    }

}


const mapStateToProps = (state) => {
    return {tags : state.tag.tags}
    
}

const mapDispatchToProps = (dispatch) => {
    return {
        fetchTags: () => dispatch(fetchTags()),
        selectTag: (tagName) => dispatch(selectTag(tagName))
    }
    
}


export default connect(mapStateToProps, mapDispatchToProps)(TagSelect);